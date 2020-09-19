import Layout from '@/layout/index'

const articleRouter = {
  path: '/article',
  component: Layout,
  redirect: 'noRedirect',
  name: '文章管理',
  meta: {
    title: '文章管理',
    icon: 'chart'
  },
  children: [
    {
      path: 'list',
      component: () => import('@/views/article/list'),
      name: '文章列表',
      meta: { title: '文章列表', noCache: true }
    }, {
      path: 'generate',
      component: () => import('@/views/article/list'),
      name: '文章生成',
      meta: { title: '文章生成', noCache: true }
    }
  ]
}

export default articleRouter
