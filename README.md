## 概述

MongoDB是一个基于分布式文件存储的数据库。由C++语言编写。旨在为WEB应用提供可扩展的高性能数据存储解决方案。

MongoDB是一个介于关系数据库和非关系数据库之间的产品，是非关系数据库当中功能最丰富，最像关系数据库的。

它支持的数据结构非常松散，是类似json的bson格式，因此可以存储比较复杂的数据类型。

Mongo最大的特点是它支持的查询语言非常强大，其语法有点类似于面向对象的查询语言，几乎可以实现类似关系数据库单表查询的绝大部分功能，而且还支持对数据建立索引。

## 适用场景

主要场景如下：
1）网站实时数据处理。它非常适合实时的插入、更新与查询，并具备网站实时数据存储所需的复制及高度伸缩性。
2）缓存。由于性能很高，它适合作为信息基础设施的缓存层。在系统重启之后，由它搭建的持久化缓存层可以避免下层的数据源过载。
3）高伸缩性的场景。非常适合由数十或数百台服务器组成的数据库，它的路线图中已经包含对MapReduce引擎的内置支持。

不适用的场景如下：
1）要求高度事务性的系统。
2）传统的商业智能应用。
3）复杂的跨文档（表）级联查询。

## MongoDB安装

废话不多说，mongodb网上的资料很多，就不一一累述了，直接操作

参照官网安装，[https://docs.mongodb.com/manual/tutorial/install-mongodb-on-red-hat/](https://docs.mongodb.com/manual/tutorial/install-mongodb-on-red-hat/)

安装前注意: 此教程是通过yum安装的，centos系统，MongoDB最新版本4.2

1、配置包管理系统（yum）
创建一个/etc/yum.repos.d/mongodb-org-4.2.repo文件，以便您可以使用yum以下命令直接安装MongoDB ：
	
    vi  /etc/yum.repos.d/mongodb-org-4.2.repo

 然后复制下面配置,保存退出	
 

    [mongodb-org-4.2] 
    name = MongoDB Repository 
    baseurl = https://repo.mongodb.org/yum/redhat/$releasever/mongodb-org/4.2/x86_64/ 
    gpgcheck = 1 
    enabled = 1 
    gpgkey = https：// www.mongodb.org/static/pgp/server-4.2.asc

 2、安装MongoDB包
要安装最新的稳定版MongoDB，请输入以下命令：
	
    sudo yum install -y mongodb-org


3、安装完毕后修改配置文件:
	
    vi /etc/mongod.conf 

修改配置文件的 bind_ip, 默认是 127.0.0.1 只限于本机连接。所以安装完成后必须把这个修改为 0.0.0.0 ,远程没法连接!

    # network interfaces
    net:
      port: 27017
      bindIp: 0.0.0.0  # Enter 0.0.0.0,:: to bind to all IPv4 and IPv6 addresses or, alternatively, use the net.bindIpAll setting.



（可选）找到 #security：改成下图所示，开启安全认证。
 注意缩进，若是缩进不对可能导致后面服务重启报错

    security：
        authorization: enabled

4、关闭防火墙

查看防火状态

    systemctl status firewalld

暂时关闭防火墙

    systemctl stop firewalld

永久关闭防火墙

    systemctl disable firewalld

5、启动、停止、重启

MongoDB默认将数据文件存储在/var/lib/mongo目录，默认日志文件在/var/log/mongodb中。如果要修改,可以在 /etc/mongod.conf 配置中指定备用日志和数据文件目录。

启动命令:
	
    sudo service mongod start

 停止命令:
	
    sudo service mongod stop

 重启命令:

    sudo service mongod restart

查看日志文件

    cat /var/log/mongodb/mongod.log

检查是否启动成功

    sudo chkconfig mongod on

6、使用
	
    mongo

# MongoDB图形化界面安装（Linux）
安装步骤参照官网：[https://docs.mongodb.com/compass/current/install/](https://docs.mongodb.com/compass/current/install/)

1、MongoDB Compass下载
官网下载安装包：[https://www.mongodb.com/download-center/compass?jmp=docs](https://www.mongodb.com/download-center/compass?jmp=docs)

下载适用于Red Hat Enterprise Linux的最新版MongoDB Compass。MongoDB Compass安装程序是一个 .rpm包。社区版本免费，我们下载社区版的RedHat的安装包。
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190918174818825.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MzI4NzUwOA==,size_16,color_FFFFFF,t_70)2、MongoDB Compass安装

    sudo yum install mongodb-compass-1.17.0.x86_64.rpm

3、MongoDB Compass启动

    mongodb-compass

# MongoDB图形化界面安装（Windows）
1、系统要求

 - 64位版本的Microsoft Windows 7或更高版本。
 - MongoDB 3.6或更高版本。
 - Microsoft .NET Framework 4.5或更高版本。

> 如果您的系统上尚未安装.NET Framework，则Compass安装程序会提示您安装所需的最低版本.NET Framework。

2、MongoDB Compass下载
官网下载：[https://www.mongodb.com/download-center/compass?jmp=docs](https://www.mongodb.com/download-center/compass?jmp=docs)

MongoDB Compass安装程序可以下载一个.exe或.msi包或.zip 存档。
下载最新版本的MongoDB Compass for Windows。
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190918175425360.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MzI4NzUwOA==,size_16,color_FFFFFF,t_70)3、MongoDB Compass安装

 - 双击安装程序文件。
 - 按照提示安装Compass。您可以选择Compass安装的目标。
 - 安装后，Compass将启动并提示您配置隐私设置并指定更新首选项。

4、MongoDB Compass安装成功
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190918175642736.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MzI4NzUwOA==,size_16,color_FFFFFF,t_70)5、MongoDB连接
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190918175718275.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MzI4NzUwOA==,size_16,color_FFFFFF,t_70)
# 数据库基本操作

**创建数据库**

    use test
    
创建的数据库 test,并不在数据库的列表中， 要显示它，我们需要向 test数据库插入一些数据。

    db.collection.insert({"name":"测试数据"})

**查看数据库**

    show dbs;

 
**查看数据库版本**

     db.version();

**创建集合（表）**

    db.createCollection("collection")

**查看集合（表）**

    show collections

**插入文档（数据）**

     db.collection.insert({"name":"测试数据"})


**查询文档（数据）**

    db.collection.find().pretty()


**更新文档（数据）**

    db.collection.update({"name":"修改数据"})

**删除文档（数据）**

    db.col.remove({"name":"修改数据"})

# 删除MongoDB
1、**停止MongoDB**
mongod通过发出以下命令来停止该过程：

    sudo service mongod stop

2、**删除包**
删除以前安装的所有MongoDB软件包。

    sudo yum erase $（ rpm -qa | grep mongodb-org ）

3、**删除数据目录**
删除MongoDB数据库和日志文件。
	
    sudo rm -r / var / log / mongodb
    sudo rm -r / var / lib / mongo


## SpringBoot对MongoDB支持
springboot已经支持mongodb，只需要引用依赖就能使用。

**pom.xml文件新增依赖项**

    <!--MongoDB数据库-->
            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-starter-data-mongodb</artifactId>
            </dependency>


**修改MongoDB连接**

    spring:
      application:
        name: spirng-boot-demo
      data:
        mongodb:
          host: 192.168.16.135
          port: 27017
          database: test

**对用户的增删改查操作**
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190918163506693.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MzI4NzUwOA==,size_16,color_FFFFFF,t_70)具体代码请看源码（往下翻一点点）

## 源码
GitHub：[https://github.com/lhb124520/MongoDBDemo](https://github.com/lhb124520/MongoDBDemo)

码云：[https://gitee.com/lhblearn/MongoDBDemo](https://gitee.com/lhblearn/MongoDBDemo)

