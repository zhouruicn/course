# 前后端脚本的差异

O2OA中复杂的应用通常需要通过Javascript来实现。根据运行环境的差异，分为前后端脚本。

前端脚本是运行在浏览器上的，本系统的前端脚本基于[mootools](https://mootools.net/)来构建，遵循ECMAScript 5.1规范。后端脚本运行在服务器上，基于基于JDK8标准的[Nashorn](https://www.n-k.de/riding-the-nashorn)，遵循ECMAScript 5.1规范。

前端脚本在本系统的[AP](http://dev.o2oa.net/x_desktop/portal.html?id=dcd8e168-2da0-4496-83ee-137dc976c7f6&page=b80ecfe9-a0df-4797-84f4-a28ed3bee550)I中有详细介绍，这里不再过多介绍。后端脚本在视图列脚本、流程事件、接口和代理中都有使用，并且这些地方的上下文都有不同。

|  | 前端脚本 | 视图列 | 流程事件 | 接口和代理 |
| :--- | :--- | :--- | :--- | :--- |
| 运行环境 | 浏览器 | 服务器端 | 服务器端 | 服务器端 |
| 访问DOM对象 | 允许 | 不允许 | 不允许 | 不允许 |
| API方法 | [查看](http://dev.o2oa.net/x_desktop/portal.html?id=dcd8e168-2da0-4496-83ee-137dc976c7f6&page=b80ecfe9-a0df-4797-84f4-a28ed3bee550) | this.value\(本列的列值\)、this.entry\(本行的数据\) | this.data、this.workContext、this.org | this.org |
| 允许使用“脚本组件” | 可以使用this.include\(\)跨应用调用，比如流程中的脚本可以调用门户中的脚本组件。 | 不允许 | 允许使用本应用 | 不允许 |
| 使用JAVA | 不允许 | 不允许 | 允许 | 允许 |

