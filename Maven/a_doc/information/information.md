# Maven介绍

http://maven.apache.org/ 

比较稳定的maven版本：apache-maven-3.6.3

Maven是专门用于管理和构建Java项目的工具，它的主要功能有：

* 提供了一套标准化的项目结构

* 提供了一套标准化的构建流程（编译，测试，打包，发布……）

* 提供了一套依赖管理机制

**标准化的项目结构：**

项目结构我们都知道，每一个开发工具（IDE）都有自己不同的项目结构，它们互相之间不通用。我再eclipse中创建的目录，无法在idea中进行使用，这就造成了很大的不方便。

而Maven提供了一套标准化的项目结构，所有的IDE使用Maven构建的项目完全一样，所以IDE创建的Maven项目可以通用。如下图右边就是Maven构建的项目结构。

![image-20210726153815028](assist/image-20210726153815028.png)

**标准化的构建流程：**编译、测试、打包、发布

**依赖管理：**

Maven使用标准的 ==坐标== 配置来管理各种依赖，只需要简单的配置就可以完成依赖管理。

# Maven模型

* 项目对象模型 (Project Object Model)
* 依赖管理模型(Dependency)
* 插件(Plugin)

![image-20210726155759621](assist/image-20210726155759621.png)

# 仓库

依赖jar包是存储在我们的本地仓库中。而项目运行时从本地仓库中拿需要的依赖jar包。

**仓库分类：**

* 本地仓库：自己计算机上的一个目录

* 中央仓库：由Maven团队维护的全球唯一的仓库

  * 地址： https://repo1.maven.org/maven2/

* 远程仓库(私服)：一般由公司团队搭建的私有仓库

![image-20210726162815045](assist/image-20210726162815045.png)

# Maven 常用命令

进入到项目的 `pom.xml` 目录下，打开命令提示符

```css
#编译，项目下会出现一个 `target` 目录，编译后的字节码文件就放在该目录下
mvn compile

#清理，删除项目下的 `target` 目录
mvn clean

#测试，执行所有的测试代码
mvn test

#打包，将当前项目打成的jar包，在 `target` 目录下
mvn package

#安装，将当前项目打成jar包，并安装到本地仓库
mvn install
```

#  Maven 生命周期

Maven 构建项目生命周期描述的是一次构建过程经历经历了多少个事件

Maven 对项目构建的生命周期划分为3套：

* clean ：清理工作。
* default ：核心工作，例如编译，测试，打包，安装等。
* site ： 产生报告，发布站点等。这套声明周期一般不会使用。

同一套生命周期内，执行后边的命令，前面的所有命令会自动执行。例如默认（default）生命周期如下：

![image-20210726173153576](assist/image-20210726173153576.png)

当我们执行后面的命令时，他会先执行前面的命令

默认的生命周期也有对应的很多命令，其他的一般都不会使用，我们只关注常用的：

![image-20210726173619353](assist/image-20210726173619353.png)



# Maven 坐标

**Maven 坐标主要组成**：

* groupId：定义当前Maven项目隶属组织名称（通常是域名反写，例如：com.itheima）
* artifactId：定义当前Maven项目名称（通常是模块名称，例如 order-service、goods-service）
* version：定义当前项目版本号

**依赖范围**：

通过设置坐标的依赖范围(scope)，可以设置 对应jar包的作用范围：编译环境、测试环境、运行环境。

| **依赖范围** | 编译classpath | 测试classpath | 运行classpath | 例子              |
| ------------ | ------------- | ------------- | ------------- | ----------------- |
| **compile**  | Y             | Y             | Y             | logback           |
| **test**     | -             | Y             | -             | Junit             |
| **provided** | Y             | Y             | -             | servlet-api       |
| **runtime**  | -             | Y             | Y             | jdbc驱动          |
| **system**   | Y             | Y             | -             | 存储在本地的jar包 |

如果引入坐标不指定 `scope` 标签时，默认就是 compile  值。以后大部分jar包都是使用默认值。