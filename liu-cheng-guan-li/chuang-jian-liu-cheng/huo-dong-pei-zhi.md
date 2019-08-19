# 活动配置

创建流程后，可以在当前流程中创建所需活动。创建方法有3种： 方法1：在控件栏里，选中需要创建的活动类型，按住鼠标左键拖动到流程编辑区放开，即可在流程编辑区创建一个新的活动。 控件栏提供了多种活动类型，除了“开始”活动每个流程只能有一个之外，其他活动类型均可有多个。 方法2：在快捷工具栏里，点“ ”，从下拉菜单里选择需要创建的活动类型。快捷工具栏同样提供了多种活动类型：

![](../../.gitbook/assets/image%20%28103%29.png)

方法3：在流程编辑区空白处点击鼠标右键，鼠标移动到弹出菜单里的“新建活动”行，从二级菜单中选择需要创建的活动类型。

![&#x6BCF;&#x79CD;&#x6D3B;&#x52A8;&#x90FD;&#x6709;&#x5176;&#x4E2A;&#x6027;&#x5316;&#x7684;&#x56FE;&#x6807;&#xFF0C;&#x90E8;&#x5206;&#x6D3B;&#x52A8;&#x5728;&#x56FE;&#x6807;&#x53F3;&#x8FB9;&#x663E;&#x793A;&#x540D;&#x79F0;&#xFF0C;&#x5982;&#x201C;&#x4EBA;&#x5DE5;&#x201D;&#x6D3B;&#x52A8;&#x3002;&#x540D;&#x79F0;&#x5728;&#x6D3B;&#x52A8;&#x7684;&#x201C;&#x57FA;&#x672C;&#x201D;&#x5C5E;&#x6027;&#x91CC;&#x4FEE;&#x6539;&#x3002; &#x6D3B;&#x52A8;&#x7C7B;&#x578B;&#x5305;&#x62EC;&#xFF1A;](../../.gitbook/assets/image%20%2844%29.png)

  
活动类型包括：

| **活动类型** | **图标** | **说明** |
| :--- | :--- | :--- |
| 开始 | ![](file:///C:/Users/zhour/AppData/Local/Temp/msohtmlclip1/01/clip_image002.jpg) | 流程的起点，在创建流程的时候自动创建了一个开始活动，一个流程只允许有一个开始活动； |
| 结束 | ![](file:///C:/Users/zhour/AppData/Local/Temp/msohtmlclip1/01/clip_image004.jpg) | 流程的终点，在创建流程的时候自动创建了一个结束活动，可以有多个结束活动； |
| 取消 | ![](file:///C:/Users/zhour/AppData/Local/Temp/msohtmlclip1/01/clip_image006.jpg) | 流程的中止，流程流转到该步骤时自动中止流程； |
| 人工 | ![](file:///C:/Users/zhour/AppData/Local/Temp/msohtmlclip1/01/clip_image008.jpg) | 需要有人工参与的活动，必须设置活动的处理方式、处理人和权限； |
| 选择 | ![](file:///C:/Users/zhour/AppData/Local/Temp/msohtmlclip1/01/clip_image010.jpg) | 需要由处理人选择下步骤活动的活动类型； |
| 拆分 | ![](file:///C:/Users/zhour/AppData/Local/Temp/msohtmlclip1/01/clip_image012.jpg) | 该活动可以通过一个路由条件到多个节点，多个节点可以同时进行后续流程，互不干扰；拆分活动必须与合并活动相对应。 |
| 并行 | ![](file:///C:/Users/zhour/AppData/Local/Temp/msohtmlclip1/01/clip_image014.jpg) |  |
| 合并 | ![](file:///C:/Users/zhour/AppData/Local/Temp/msohtmlclip1/01/clip_image016.jpg) | 拆分环节全部完成后需要合并； |
| 调用 | ![](file:///C:/Users/zhour/AppData/Local/Temp/msohtmlclip1/01/clip_image018.jpg) | 调用WebService接口，支持JAX-WS和JAX-RS规范 |
| 脚本 | ![](file:///C:/Users/zhour/AppData/Local/Temp/msohtmlclip1/01/clip_image020.jpg) | 按照脚本执行活动 |

 **编辑活动属性**

单击活动，活动图标周围出现橙色虚线边框，说明已选中该活动，同时属性编辑框显示该活动的所有属性：

![](../../.gitbook/assets/image%20%289%29.png)

![](../../.gitbook/assets/image%20%28114%29.png)

![](../../.gitbook/assets/image%20%2858%29.png)



  


**4** **事件属性**

| 文档到达前 | 脚本，在工作文档完成上步骤操作，未到达当前活动前执行 |
| :--- | :--- |
| 文档到达后 | 脚本，在工作文档完成上步骤操作，并已到达当前活动后执行 |

**5** **拆分属性（拆分活动特有）**

| 拆分依据脚本 | 脚本，在工作文档进行拆分时执行 |
| :--- | :--- |


**6** **调用属性（调用活动特有）**

| 服务协议 | 单选，调用所使用的协议类型 |
| :--- | :--- |
| WSDL地址 | 服务协议选“jaxws”时输入 |
| 调用方法 | 服务协议选“jaxws”时输入 |
| REST地址 | 服务协议选“jaxrs”时输入 |
| 调用方法 | 下拉框，服务协议选“jaxrs”时选择 |
| ContentType | 服务协议选“jaxrs”时输入 |
| 参数脚本 | 脚本，在工作文档到达当前活动后执行 |

![](file:///C:/Users/zhour/AppData/Local/Temp/msohtmlclip1/01/clip_image002.jpg)

**7** **脚本属性（脚本活动特有）**

| 执行脚本 | 脚本，在工作文档到达当前活动后执行 |
| :--- | :--- |




