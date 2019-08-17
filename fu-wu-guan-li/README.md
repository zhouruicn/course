# 服务管理

服务管理包括代理和接口，都是在服务端运行。O2OA中代理就是定时任务。接口可以提供Http服务让外部程序调用。

代理和接口运行的都是后端脚本。在O2OA中，后端脚本也是Javascript，基于JDK8标准的Nashorn，遵循ECMAScript 5.1规范。如果您需要了解Nashorn，可以[点击此查看](https://www.n-k.de/riding-the-nashorn/#_nashorn_at_the_command_line_interface_cli)。

系统在代理和接口分别提供了上下文给脚本使用，详情可以查看本章的代理和接口两个小节。

