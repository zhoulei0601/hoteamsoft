import { createApp } from 'vue'
import App from './App.vue'
import 'font-awesome/css/font-awesome.min.css'
import ElementPlus from 'element-plus' 
import 'element-plus/theme-chalk/index.css' 
import * as ElementPlusIconsVue from '@element-plus/icons-vue'
import Antd from 'ant-design-vue';
import 'ant-design-vue/dist/antd.css';

const app = createApp(App);
app.use(ElementPlus);
app.use(Antd)
app.mount('#app')

// 注册全局组件
for (let [key, component] of Object.entries(ElementPlusIconsVue)) {
    app.component(key, component)
}