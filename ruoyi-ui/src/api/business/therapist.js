import request from '@/utils/request'

// 查询陪诊师列表
export function listTherapist(query) {
  return request({
    url: '/system/therapist/list',
    method: 'get',
    params: query
  })
}

// 查询陪诊师详细
export function getTherapist(id) {
  return request({
    url: '/system/therapist/' + id,
    method: 'get'
  })
}

// 新增陪诊师
export function addTherapist(data) {
  return request({
    url: '/system/therapist',
    method: 'post',
    data: data
  })
}

// 修改陪诊师
export function updateTherapist(data) {
  return request({
    url: '/system/therapist',
    method: 'put',
    data: data
  })
}

// 删除陪诊师
export function delTherapist(id) {
  return request({
    url: '/system/therapist/' + id,
    method: 'delete'
  })
}
