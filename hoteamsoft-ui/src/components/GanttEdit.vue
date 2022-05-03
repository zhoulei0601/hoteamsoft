<template>
  <div ref="gantt"></div>
</template>

<script>
import {gantt} from 'dhtmlx-gantt';

export default {
  name: 'GanttEdit',
  props: {
    tasks: {
      type: Object,
      default () {
        return {data: [], links: []}
      }
    }
  },
  methods: {
    initGantt(){
       //设置x轴⽇期
     /*  gantt.config.scale_unit = 'day'
      gantt.config.step = 1
      gantt.config.date_scale = '星期' + '%D' */
      gantt.config.xml_date = "%Y-%m-%d";
      gantt.i18n.setLocale("cn");
      gantt.init(this.$refs.gantt);
      gantt.parse(this.$props.tasks);
    },
    //任务增加、删除、修改
    configGanttEvent(){
      gantt.attachEvent("onTaskClick", function(id, e){
        var button = e.target.closest("[data-action]")
        if(button){
            var action = button.getAttribute("data-action");
            switch (action) {
                case "edit":
                    gantt.showLightbox(id);
                    break;
                case "add":
                    gantt.createTask(null, id);
                    break;
                case "delete":
                    gantt.confirm({
                        title: gantt.locale.labels.confirm_deleting_title,
                        text: gantt.locale.labels.confirm_deleting,
                        callback: function (res) {
                            if (res)
                                gantt.deleteTask(id);
                        }
                    });
                    break;
            }
            return false;

        }
        return true;
    });
    },
    configFreeze(){
      gantt.config.layout = {
          css: "gantt_container",
          cols: [
              {
              rows:[
                  {view: "grid", scrollX: "gridScroll", scrollable: true, scrollY: "scrollVer"},
                  {view: "scrollbar", id: "gridScroll", group:"horizontal"}
              ]
              },
              {resizer: true, width: 1},
              { 
              rows:[
                  {view: "timeline", scrollX: "scrollHor", scrollY: "scrollVer"},
                  {view: "scrollbar", id: "scrollHor", group:"horizontal"}
              ]
              },
              {view: "scrollbar", id: "scrollVer"}
          ]
      };
    },
    exportToPNG(){
      gantt.exportToPDF({
        name:"my_beautiful_gantt.pdf"});
      }
  },
  mounted: function () {
   // this.configFreeze();
    this.configGanttEvent();
    this.initGantt();    
    /* gantt.createDataProcessor((entity, action, data, id) => {
      this.$emit(`${entity}-updated`, id, action, data);
    }); */
    const that = this;
    gantt.createDataProcessor({
      task: {
        create: function(data) {
          console.log('新增任务----------------------')
          gantt.ajax.post(that.serverUrl + '/createData', data)
        },
        update: function(data, id) {
          console.log('更新任务----------------------')
          gantt.ajax.put(that.serverUrl + '/updateData', data)
        },
        delete: function(id) {
          console.log('删除任务----------------------')
          gantt.ajax.del(that.serverUrl + '/deleteData?id=' + id)
        }
      },
      link: {
        create: function(data) {
          console.log('link.create----------------------')
        },
        update: function(data, id) {
          console.log('link.update----------------------')
        },
        delete: function(id) {
          console.log('link.delete----------------------')
        }
      }
    })
  }
}
</script>

<style scoped>
  @import "~dhtmlx-gantt/codebase/dhtmlxgantt.css";
</style>
