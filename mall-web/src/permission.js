import router from './router'
import NProgress from 'nprogress' //Progress进度条
import store from './store'
import {getToken} from "./utils/auth"; //验权


router.beforeEach((to, from, next) => {
  NProgress.start()

  if (getToken()) {

    if (to.path === '/login') {
      next({path: '/'})
      NProgress.done()
    } else {
      if (store.getters.roles.length === 0) {

      }
    }
  }

})
