<template>
  <div class="common-layout container" >
    <el-container>
      <el-header>
         <el-form :inline="true" :model="form" class="demo-form-inline">
           <el-form-item label="项目名称">
              <el-input v-model="form.projectName"/>
           </el-form-item>
           <el-form-item label="项目编号">
              <el-input v-model="form.projectCode"/>
           </el-form-item>
           <el-form-item label="">
             <el-button @click="search">查询</el-button>
           </el-form-item>
         </el-form>
      </el-header>
      <el-main>
        <el-row>
          <el-button :icon="Plus" @click="addTask">
            <el-icon style="vertical-align: middle">
              <Plus/>
            </el-icon>
          </el-button>
          <el-button :icon="Edit">
            <el-icon style="vertical-align: middle">
              <Edit/>
            </el-icon>
          </el-button>
          <el-button :icon="Delete" circle >
            <el-icon style="vertical-align: middle">
              <Delete />
            </el-icon>
          </el-button>
          <el-button :icon="Check" circle @click="saveTaskLink">
            <el-icon style="vertical-align: middle">
              <Check />
            </el-icon>
          </el-button>
        </el-row>
        <GanttEdit class="left-container" :tasks="tasks" @task-updated="logTaskUpdate" @link-updated="logLinkUpdate"/>
      </el-main>
    </el-container>
  </div>
</template>

<script>
import { gantt } from 'dhtmlx-gantt';
import GanttEdit from './components/GanttEdit.vue';
import {getTaskLinks,saveTaskLink} from './api/gantt/gantt'
import {Edit,Delete,Plus,Check} from '@element-plus/icons-vue'


export default {
  name: 'App',
  components: {
    GanttEdit,
    Plus,
    Edit,
    Delete,
    Check
  },
  data () {
    return {
      tasks: {
        data:[
          {"id":1, "text":"Project #1", "start_date":"01-04-2020", "duration":18},
          {"id":2, "text":"Task #1", "start_date":"02-04-2020","duration":8, "parent":1},
          {"id":3, "text":"Task #2", "start_date":"11-04-2020","duration":8, "parent":1}
        ],
        links:[
          {"id":1, "source":1, "target":2, "type":"1"},
          {"id":2, "source":2, "target":3, "type":"0"}
        ]
      },
      form: {
        projectName: ""
      }
    }
  },
  methods: {
    
    addMessage (message) {
      this.messages.unshift(message)
      if (this.messages.length > 40) {
        this.messages.pop()
      }
    },
 
    logTaskUpdate (id, mode, task) {
      let text = (task && task.text ? ` (${task.text})`: '')
      let message = `Task ${mode}: ${id} ${text}`
      this.addMessage(message)
    },
 
    logLinkUpdate (id, mode, link) {
      let message = `Link ${mode}: ${id}`
      if (link) {
        message += ` ( source: ${link.source}, target: ${link.target} )`
      }
      this.addMessage(message)
    },
    configGrantt(){
        //表格列自适应
        gantt.config.autofit = true;
       gantt.config.columns = [
        {name: "text",label: "项目名称", tree: true, resize: true},
        {name: "projectState",label: "项目状态",resize: true},
        {name: "projectCode",label: "项目编码",resize: true},
        {name: "projectType",label: "项目类型",resize: true},
        {name: "projectLevel",label: "项目级别", resize: true},
        {name: "projectLevel",label: "项目级别", resize: true},
        {name: "start_date",label: "开始时间", align: "center", resize: true},
        {name: "duration",label: "持续时长", align: "center"},
        {name: "processState",label: "进展状态", align: "center"},
        {name: "planProgressPercent",label: "计划进度", align: "center"},
        {name: "realProgressPercent",label: "实际进度", align: "center"},
        {name: "managerId",label: "项目经理", align: "center"},
        /* {name: "buttons",label: "操作",width: 75,template: function () {
            return (
                '<i class="fa fa-pencil" data-action="edit"></i>&nbsp;' +
                '<i class="fa fa-plus" data-action="add"></i>&nbsp;&nbsp;' +
                '<i class="fa fa-times" data-action="delete"></i>'
                );
        }} */
      ];
      console.log(gantt)
    },
    addTask(){
      var tasksStore = gantt.getDatastore("task");
      console.log(tasksStore);
      gantt.addTaskLayer(function draw_deadline(task) {
          if (task.deadline) {
              var el = document.createElement('div');
              el.className = 'deadline';
              var sizes = gantt.getTaskPosition(task, task.deadline);
      
              el.style.left = sizes.left + 'px';
              el.style.top = sizes.top + 'px';
      
              el.setAttribute('title', gantt.templates.task_date(task.deadline));
              return el;
          }
          return false;
      });
    },
    saveTaskLink(){
      let data = this.getTaskLinksData();
      saveTaskLink(data);
    },
    getTaskLinksData(){
      const taskIds = gantt.getDatastore("task").fullOrder;
      let tasks = [];
      for(let id of taskIds){
        tasks.push(gantt.getTask(id));
      }
      return {data: tasks,links: gantt.getLinks()};
    },
    parseGranttData(data){
      for(let o of data){
        if(o.pid){
          o.parent = o.pid;
        }
        o.text = o.projectName;
        o.start_date = o.startTime;
      }
    },
    filterVal(){
      const _this = this;
      gantt.attachEvent("onBeforeTaskDisplay", function(id, task){
      const form = _this.form;
      if(!form) return true;
      if(form.projectName){
        return task.text.indexOf(form.projectName) > -1;
      }
      return true; 
      });
    },
    search(){
      gantt.render();
    },
    reloadGrantt(data){
      gantt.clearAll();
      gantt.parse(data);
      gantt.render();
    },
    exportPdf(){
      console.log(gantt)
      gantt.exportToPDF();
    }
  },
  created() {
    this.configGrantt();
    let that = this;
    getTaskLinks().then(res =>{
      that.parseGranttData(res.data.data)
      that.reloadGrantt(res.data)
      console.log(res);
    })
  },
  mounted() {
    this.filterVal();
  },
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
 html, body {
    margin: 0;
    padding: 0;
  }
  .el-main{
    width:100%;
    height: 500px;
  }
  .left-container {
    overflow: hidden;
    position: relative;
    height: 100%;
  }
</style>
