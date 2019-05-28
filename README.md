# shirodemo
该系统用的是SSM框架，同时用了shiro做了权限管理，前端数据的异步通信用了vue和ajax，数据库用的是mysql，我用的是Tomcat8  <br/>
该文件是在eclipse里创建的，下载后如果要在本机运行需要进行一些配置  <br>
<li>数据库文件在src的resource下面的shirodemo.sql，用mysql运行就ok了，数据库名字也是shirodemo</li>
<li>1.需要先配置Tomcat的server.xml文件</li>
<image  src="https://github.com/codeHaoHao/readME-file/blob/master/shirodemo-readME/1.png"/>
如上图所示需要在tomcat的server.xml的<Host></Host>标签中加入下面这一句话<br/>
<Context docBase="E:/upload/uploadImages/" path="/uploadImages" reloadable="true"/><br/>
这句话中的路径可以改为自定义的路径，该路径存储的是你上传的文件路径<br/>
<li>2.修改文件中的路径</li>
同时如果你修改了上传文件的路径的话，在项目的cn.lijiahao.demo.controller.UserController中也要修改路径,如下图的path路径：<br/>
<image src="https://github.com/codeHaoHao/readME-file/blob/master/shirodemo-readME/2019-03-25_134158.png"><br/>
还要修改cn.lijiahao.demo.utils.ImageUploadUtil中的路径，如下图：<br/>
<image src="https://github.com/codeHaoHao/readME-file/blob/master/shirodemo-readME/2019-03-25_134615.png"><br/>
<li>3.将相关图片复制到指定路径</li><br/>
在项目的resource下面有个upload文件，该文件中都是已经上传的图片将该文件复制到你在Tomcat的server.xml文件中指定的路径下<br/>
<li>4.数据库的结构和数据文件也在项目的resource目录下</li><br/>



## 项目运行成果图
首页<br/>
<image src="https://github.com/codeHaoHao/readME-file/blob/master/shirodemo-readME/index.png"><br/>
登录<br/>
<image src="https://github.com/codeHaoHao/readME-file/blob/master/shirodemo-readME/login.png"><br/>
admin<br/>
<image src="https://github.com/codeHaoHao/readME-file/blob/master/shirodemo-readME/admin.png"><br/>
文章页面<br/>
<image src="https://github.com/codeHaoHao/readME-file/blob/master/shirodemo-readME/moment.png"><br/>
用户页面<br/>
<image src="https://github.com/codeHaoHao/readME-file/blob/master/shirodemo-readME/user.png"><br/>

谢谢观看，该项目还有许多的不足之处
