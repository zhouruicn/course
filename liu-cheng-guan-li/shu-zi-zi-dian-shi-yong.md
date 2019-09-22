# 数据字典使用说明

## 一、当前应用获取数字字典

var dict = new this.Dict\("fileSource"\); //fileSource 数据字典的名称 

var bxtype = dict.get\("报销类型"\); //报销类型，项目名称 

return bxtype; //返回值

## 二、跨应用获取数字字典

var dict = new this.Dict\({ 

type : "cms", //应用类型。可以为process cms。如果没有该选项或者值为空字符串，则表示应用脚本和被应用的脚本配置类型相同；比如在流程的A应用脚本中引用流程B应用的脚本配置，则type可以省略。

 application : "bulletin", //流程、CMS的名称、别名、id, 默认为当前应用 

name : "bulletinDictionary", // 数据字典的名称、别名、id 

enableAnonymous : true //允许用户在未登录的情况下读取cms的数据字典, type为process的时候此参数无效，默认为false }\);

var bxtype = dict.get\("报销类型"\); //报销类型，项目名称 

return bxtype; //返回值

