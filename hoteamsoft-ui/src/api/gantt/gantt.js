import request from '@/utils/request'


// 获取所有任务及任务依赖关系  { "data": [{ "id": 1, "taskName": "Task", "startDate": "2020-01-17", "endDate": "2020-01-27", "progress": 0.6 }], "links": [{ "id": 1, "sourceId": 1, "targetId": 2, "type": "0" }] }
export function getTaskLinks () {
    return request({
      url: '/projectGantt/getTaskLinks',
      method: 'get'
    })
  }

//添加任务 {"startDate": "2020-01-17","taskName": "新任務","duration": 1,"endDate": "2020-01-18","progress": 0,"pid": 0}
export function addTask(task){
  return request({
    url: '/projectGantt',
    method: 'post',
    data: task
  })
}  

//更新任务  {"id": 1650591486878,"startDate": "2020-01-17","taskName": "新任務","duration": 1,"endDate": "2020-01-18","progress": 0,"pid": 0}
export function updateTask(task){
  return request({
    url: '/projectGantt',
    method: 'put',
    data: task
  })
}

//删除任务
export function deleteTask(taskId){
  return request({
    url: `/projectGantt/${taskId}`,
    method: 'delete'
  })
}

//添加任务关系  {"sourceId": 1, "targetId": 2, "type": "0" }
export function addTaskLink(link){
  return request({
    url: '/projectGanttLink',
    method: 'post',
    data: link
  })
}

//更新任务关系 { "id": 1, "sourceId": 1, "targetId": 2, "type": "0" }
export function updateTaskLink(link){
  return request({
    url: '/projectGanttLink',
    method: 'put',
    data: link
  })
}

//删除任务关系 
export function deleteTaskLink(linkId){
  return request({
    url: `/projectGanttLink/${linkId}`,
    method: 'delete'
  })
}

//保存全部 { "data": [{ "id": 1, "taskName": "Task", "startDate": "2020-01-17", "endDate": "2020-01-27", "progress": 0.6 }], "links": [{ "id": 1, "sourceId": 1, "targetId": 2, "type": "0" }] }
export function saveTaskLink(obj){
  return request({
    url: '/projectGantt/saveTaskLink',
    method: 'post',
    data: obj
  })
}