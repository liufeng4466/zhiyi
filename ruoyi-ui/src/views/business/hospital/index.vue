<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="医院名称" prop="name">
        <el-input
          v-model="queryParams.name"
          placeholder="请输入医院名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="城市名称" prop="city">
        <el-select v-model="queryParams.city" placeholder="请选择城市" clearable style="width: 240px">
          <el-option v-for="dict in dict.type.city_type" :key="dict.value" :label="dict.label" :value="dict.value" />
        </el-select>
      </el-form-item>
      <el-form-item label="疾病分类" prop="diseaseType">
        <el-select v-model="queryParams.diseaseType" placeholder="请选择分类" clearable style="width: 240px">
          <el-option v-for="dict in dict.type.disease_type" :key="dict.value" :label="dict.label" :value="dict.value" />
        </el-select>
      </el-form-item>
      <el-form-item label="创建时间">
        <el-date-picker v-model="dateRange" style="width: 240px" value-format="yyyy-MM-dd" type="daterange" range-separator="-" start-placeholder="开始日期" end-placeholder="结束日期"></el-date-picker>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['system:hospital:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['system:hospital:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['system:hospital:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:hospital:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="hospitalList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="医院编号" align="center" prop="id" />
      <el-table-column label="医院名称" align="center" prop="name" />
      <el-table-column label="医院电话" align="center" prop="telephone" />
      <el-table-column label="医院地址" align="center" prop="address" />
      <!-- <el-table-column label="医院简介" align="center" prop="snapshot" /> -->
      <el-table-column label="城市名称" align="center" prop="city">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.city_type" :value="scope.row.city"/>
        </template>
      </el-table-column>
      <el-table-column label="病分类" align="center" prop="diseaseType">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.disease_type" :value="scope.row.diseaseType"/>
        </template>
      </el-table-column>
      <el-table-column label="经度" align="center" prop="lng" />
      <el-table-column label="纬度" align="center" prop="lat" />
      <el-table-column label="创建时间" align="center" prop="createTime">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.createTime) }}</span>
        </template>
      </el-table-column>
      <el-table-column label="创建人" align="center" prop="createBy" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:hospital:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:hospital:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改医院对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="医院名称" prop="name">
          <el-input v-model="form.name" placeholder="请输入医院名称" />
        </el-form-item>
        <el-form-item label="医院电话" prop="telephone">
          <el-input v-model="form.telephone" placeholder="请输入医院电话" />
        </el-form-item>
        <el-form-item label="医院地址" prop="address">
          <el-input v-model="form.address" placeholder="请输入医院地址" />
        </el-form-item>
        <el-form-item label="医院简介" prop="snapshot">
          <el-input v-model="form.snapshot" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="城市名称" prop="cityName">
          <el-select v-model="form.city" placeholder="请选择城市">
            <el-option v-for="dict in dict.type.city_type" :key="dict.value" :label="dict.label" :value="dict.value" />
          </el-select>
        </el-form-item>
        <el-form-item label="疾病分类" prop="diseaseType">
          <el-select v-model="form.diseaseType" placeholder="请选择分类">
            <el-option v-for="dict in dict.type.disease_type" :key="dict.value" :label="dict.label" :value="dict.value" />
          </el-select>
        </el-form-item>
        <el-form-item label="经度(lng)" prop="lng">
          <el-input v-model="form.lng" placeholder="请输入经度" />
        </el-form-item>
        <el-form-item label="纬度(lat)" prop="lat">
          <el-input v-model="form.lat" placeholder="请输入纬度" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listHospital, getHospital, delHospital, addHospital, updateHospital } from "@/api/business/hospital";

export default {
  name: "Hospital",
  dicts: ['disease_type', 'city_type'],
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 医院表格数据
      hospitalList: [],
      // 日期范围
      dateRange: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        name: null,
        city: null,
        createTime: null,
        diseaseType: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询医院列表 */
    getList() {
      this.loading = true;
      listHospital(this.addDateRange(this.queryParams, this.dateRange)).then(response => {
        this.hospitalList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id:null,
        name: null,
        telephone: null,
        address: null,
        snapshot: null,
        city: null,
        lng: null,
        lat: null,
        diseaseType: null,
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.dateRange = [];
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加医院";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getHospital(id).then(response => {
        this.form = response.data;
        console.log("-------",this.form)
        this.open = true;
        this.title = "修改医院";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateHospital(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addHospital(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除医院编号为"' + ids + '"的数据项？').then(function() {
        return delHospital(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/hospital/export', {
        ...this.queryParams
      }, `hospital_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
