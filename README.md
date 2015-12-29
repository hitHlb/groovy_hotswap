# groovy_hotswap
groovy support.  

为了弥补hotswap(@see https://github.com/hitHlb/hotswap) 无法热更静态数据，及无法热更已经在内存中的对象的成员变量的问题, 
使用groovy的特性,直接让jvm加载指定位置的groovy脚本，从而达到热更静态数据及内存中对象的成员变量的目的。
此模块除了热更还有一个重要的功能就是： 通过groovy脚本，可以直接看到jvm里面对象的值，在生产环境中查找问题非常方便
