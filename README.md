# ImageViewer

![Image](app/src/main/ic_launcher-web.png)

[![Download](https://img.shields.io/badge/download-App-blue.svg)](https://raw.githubusercontent.com/jenly1314/ImageViewer/master/app/release/app-release.apk)
[![MavenCentral](https://img.shields.io/maven-central/v/com.github.jenly1314/imageviewer)](https://repo1.maven.org/maven2/com/github/jenly1314/imageviewer)
[![JitPack](https://jitpack.io/v/jenly1314/ImageViewer.svg)](https://jitpack.io/#jenly1314/ImageViewer)
[![CircleCI](https://circleci.com/gh/jenly1314/ImageViewer.svg?style=svg)](https://circleci.com/gh/jenly1314/ImageViewer)
[![API](https://img.shields.io/badge/API-21%2B-blue.svg?style=flat)](https://android-arsenal.com/api?level=21)
[![License](https://img.shields.io/badge/license-MIT-blue.svg)](https://opensource.org/licenses/mit-license.php)

ImageViewer for Android 是一个图片查看器，一般用来查看图片详情或查看大图时使用。

## Gif 展示

![Image](GIF.gif)

> 你也可以直接下载 [演示App](https://raw.githubusercontent.com/jenly1314/ImageViewer/master/app/release/app-release.apk) 体验效果

## 引入

### Gradle:

1. 在Project的 **build.gradle** 或 **setting.gradle** 中添加远程仓库

    ```gradle
    repositories {
        //...
        mavenCentral()
        maven { url 'https://jitpack.io' }
    }
    ```

2. 在Module的 **build.gradle** 里面添加引入依赖项

    ```gradle
    implementation 'com.github.jenly1314:imageviewer:1.2.0'
    ```

## 使用

### 相关说明

* 使用 **ImageViewer** 时，必须配置一个实现的 **ImageLoader**。

* **ImageViewer** 一次可以查看多张图片或单张图片，支持的类型可以是 **Uri**、 **url** 、 **filePath** 、 **File**、 **DrawableRes**、 **ImageDataSource** 等。

* 目前内置默认实现 **ImageLoader** 的有 **CoilImageLoader** 、 **GlideImageLoader** 和 **PicassoImageLoader** ，三者选其一即可，如果以上都不满足您的需求，您也可以自己实现一个 **ImageLoader** 。

* 为了保证 **ImageViewer** 体积最小化，让用户有更多选择的可能性， **ImageViewer** 仅编译时用到了 **coil** 、**Glide** 和 **Picasso** 。

> 当你使用了 **CoilImageLoader** 时，则需依赖[coil](https://github.com/coil-kt/coil)库 （v1.2.0新增）

> 当你使用了 **GlideImageLoader** 时，则需依赖[ **Glide** ](https://github.com/bumptech/glide)库

> 当你使用了 **PicassoImageLoader** 时，则需依赖[ **Picasso** ](https://github.com/square/picasso)库

### 代码示例

示例一：简单调用

```kotlin

ImageViewer.load(model)//要加载的图片数据，单张或多张
    .imageLoader(GlideImageLoader())// 图片加载器，目前内置的有CoilImageLoader、GlideImageLoader和PicassoImageLoader，也可以自己实现
    .start(activity,sharedElement)//activity or fragment, 跳转时的共享元素视图

```

示例二：根据需要修改一些配置
```kotlin

ImageViewer.load(model)//要加载的图片数据，单张或多张
    .imageLoader(GlideImageLoader())// 图片加载器，目前内置的有CoilImageLoader、GlideImageLoader和PicassoImageLoader，也可以自己实现
    .selection(position)//当前选中位置，默认：0
    .showIndicator(true)//是否显示指示器，默认不显示
    .theme(R.style.ImageViewerTheme)//设置主题风格，默认：R.style.ImageViewerTheme
    .orientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)//设置屏幕方向,默认：ActivityInfo.SCREEN_ORIENTATION_BEHIND
    .start(activity,sharedElement)//activity or fragment, 跳转时的共享元素视图

```

特别说明：全局设置默认的图片加载器（v1.2.0新增）

```kotlin
ImageViewer.setGlobalDefaultImageLoader(imageLoader)
```
> 当设置了全局默认的图片加载器后，就可以在使用`ImageViewer`实例时，不用再单独调用`ImageViewer.imageLoader(imageLoader)`去设置图片加载器了。


更多使用详情，请查看[app](app)中的源码使用示例或直接查看 [API帮助文档](https://jenly1314.github.io/ImageViewer/api/)

## 相关推荐

- [DrawBoard](https://dgithub.xyz/jenly1314/DrawBoard) 一个自定义View实现的画板；方便对图片进行编辑和各种涂鸦相关操作。

<!-- end -->

## 版本日志

#### v1.2.0：2024-12-6
* 代码全部改为使用`kotlin`
* 更新Gradle至v8.0
* 更新compileSdk至32
* 提升minSdk至21
* 新增`CoilImageLoader`
* 新增全局设置图片加载器函数 `ImageViewer.setGlobalDefaultImageLoader(imageLoader)`

#### v1.1.0：2023-9-16
* 更新Gradle至v7.3.3
* 更新compileSdk至30
* 优化细节

#### [查看更多版本日志](CHANGELOG.md)

## 赞赏

如果您喜欢ImageViewer，或感觉ImageViewer帮助到了您，可以点右上角“Star”支持一下，您的支持就是我的动力，谢谢 :smiley:
<p>您也可以扫描下面的二维码，请作者喝杯咖啡 :coffee:

<div>
   <img src="https://jenly1314.github.io/image/page/rewardcode.png">
</div>

## 关于我

| 我的博客                                                                                | GitHub                                                                                  | Gitee                                                                                  | CSDN                                                                                 | 博客园                                                                            |
|:------------------------------------------------------------------------------------|:----------------------------------------------------------------------------------------|:---------------------------------------------------------------------------------------|:-------------------------------------------------------------------------------------|:-------------------------------------------------------------------------------|
| <a title="我的博客" href="https://jenly1314.github.io" target="_blank">Jenly's Blog</a> | <a title="GitHub开源项目" href="https://github.com/jenly1314" target="_blank">jenly1314</a> | <a title="Gitee开源项目" href="https://gitee.com/jenly1314" target="_blank">jenly1314</a>  | <a title="CSDN博客" href="http://blog.csdn.net/jenly121" target="_blank">jenly121</a>  | <a title="博客园" href="https://www.cnblogs.com/jenly" target="_blank">jenly</a>  |

## 联系我

| 微信公众号        | Gmail邮箱                                                                          | QQ邮箱                                                                              | QQ群                                                                                                                       | QQ群                                                                                                                       |
|:-------------|:---------------------------------------------------------------------------------|:----------------------------------------------------------------------------------|:--------------------------------------------------------------------------------------------------------------------------|:--------------------------------------------------------------------------------------------------------------------------|
| [Jenly666](http://weixin.qq.com/r/wzpWTuPEQL4-ract92-R) | <a title="给我发邮件" href="mailto:jenly1314@gmail.com" target="_blank">jenly1314</a> | <a title="给我发邮件" href="mailto:jenly1314@vip.qq.com" target="_blank">jenly1314</a> | <a title="点击加入QQ群" href="https://qm.qq.com/cgi-bin/qm/qr?k=6_RukjAhwjAdDHEk2G7nph-o8fBFFzZz" target="_blank">20867961</a> | <a title="点击加入QQ群" href="https://qm.qq.com/cgi-bin/qm/qr?k=Z9pobM8bzAW7tM_8xC31W8IcbIl0A-zT" target="_blank">64020761</a> |

<div>
   <img src="https://jenly1314.github.io/image/page/footer.png">
</div>
