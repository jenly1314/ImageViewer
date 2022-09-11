# ImageViewer

![Image](app/src/main/ic_launcher-web.png)

[![Download](https://img.shields.io/badge/download-App-blue.svg)](https://raw.githubusercontent.com/jenly1314/ImageViewer/master/app/release/app-release.apk)
[![MavenCentral](https://img.shields.io/maven-central/v/com.github.jenly1314/imageviewer)](https://repo1.maven.org/maven2/com/github/jenly1314/imageviewer)
[![JCenter](https://img.shields.io/badge/JCenter-1.0.2-46C018.svg)](https://bintray.com/beta/#/jenly/maven/imageviewer)
[![JitPack](https://jitpack.io/v/jenly1314/ImageViewer.svg)](https://jitpack.io/#jenly1314/ImageViewer)
[![CI](https://travis-ci.org/jenly1314/ImageViewer.svg?branch=master)](https://travis-ci.org/jenly1314/ImageViewer)
[![CircleCI](https://circleci.com/gh/jenly1314/ImageViewer.svg?style=svg)](https://circleci.com/gh/jenly1314/ImageViewer)
[![API](https://img.shields.io/badge/API-16%2B-blue.svg?style=flat)](https://android-arsenal.com/api?level=16)
[![License](https://img.shields.io/badge/license-MIT-blue.svg)](https://opensource.org/licenses/mit-license.php)
[![Blog](https://img.shields.io/badge/blog-Jenly-9933CC.svg)](https://jenly1314.github.io/)
[![QQGroup](https://img.shields.io/badge/QQGroup-20867961-blue.svg)](http://shang.qq.com/wpa/qunwpa?idkey=8fcc6a2f88552ea44b1411582c94fd124f7bb3ec227e2a400dbbfaad3dc2f5ad)

ImageViewer for Android 是一个图片查看器，一般用来查看图片详情或查看大图时使用。

## Gif 展示
![Image](GIF.gif)


## 引入

### Gradle:

1. 在Project的 **build.gradle** 里面添加远程仓库

```gradle
allprojects {
    repositories {
        //...
        mavenCentral()
    }
}
```

2. 在Module的 **build.gradle** 里面添加引入依赖项

```gradle
implementation 'com.github.jenly1314:imageviewer:1.0.4'
```


以前发布至JCenter的版本

```gradle
implementation 'com.king.image:imageviewer:1.0.2'
```


## 示例

### 代码示例

```Java
    //图片查看器 - 简单调用

    // data 可以多张图片List或单张图片，支持的类型可以是{@link Uri}, {@code url}, {@code path},{@link File}, {@link DrawableRes resId}…等
    ImageViewer.load(data)//要加载的图片数据，单张或多张
            .imageLoader(new GlideImageLoader())//加载器，imageLoader必须配置，目前内置的有GlideImageLoader或PicassoImageLoader，也可以自己实现
            .start(activity,sharedElement);//activity or fragment, 跳转时的共享元素视图

```

```Java
    //图片查看器

    // data 可以多张图片List或单张图片，支持的类型可以是{@link Uri}, {@code url}, {@code path},{@link File}, {@link DrawableRes resId}…等
    ImageViewer.load(data)//要加载的图片数据，单张或多张
            .selection(position)//当前选中位置，默认：0
            .indicator(true)//是否显示指示器，默认不显示
            .imageLoader(new GlideImageLoader())//加载器，imageLoader必须配置，目前内置的有GlideImageLoader或PicassoImageLoader，也可以自己实现
            .theme(R.style.ImageViewerTheme)//设置主题风格，默认：R.style.ImageViewerTheme
            .orientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)//设置屏幕方向,默认：ActivityInfo.SCREEN_ORIENTATION_BEHIND
            .start(activity,sharedElement);//activity or fragment, 跳转时的共享元素视图

```

### 相关说明
> * 使用 **ImageViewer** 时，必须配置一个实现的 **ImageLoader**。

> * **ImageViewer** 一次可以查看多张图片或单张图片，支持的类型可以是 **Uri**、 **url** 、 **path** 、 **File**、 **Drawable**、 **ImageDataSource** 等

> * 目前内置默认实现的 **ImageLoader** 有和 **PicassoImageLoader** ，二者选其一即可，如果二者不满足您的需求，您也可以自己实现一个 **ImageLoader**。

> * 为了保证 **ImageViewer** 体积最小化，和用户更多可能的选择性，并未将 **Glide** 和 **Picasso** 打包进 **aar**。
>>    当您使用了 **GlideImageLoader** 时，必须依赖[ **Glide** ](https://github.com/bumptech/glide)库。

>>    当您使用了 **PicassoImageLoader** 时，必须依赖[ **Picasso** ](https://github.com/square/picasso)库。


更多使用详情，请查看[app](app)中的源码使用示例

## 版本记录

#### v1.0.4：2022-9-11
*  优化细节

#### v1.0.3：2022-9-10 (从v1.0.3开始发布至 MavenCentral)
*  看大图界面支持自定义扩展

#### v1.0.2：2020-12-3
*  加载的图片数据新增支持ImageDataSource类型，便于扩展

#### v1.0.1：2019-11-15
*  简化集成步骤

#### v1.0.0：2019-11-7
*  ImageViewer初始版本

## 赞赏
如果您喜欢ImageViewer，或感觉ImageViewer帮助到了您，可以点右上角“Star”支持一下，您的支持就是我的动力，谢谢 :smiley:<p>
您也可以扫描下面的二维码，请作者喝杯咖啡 :coffee:
<div>
<img src="https://jenly1314.github.io/image/pay/wxpay.png" width="280" heght="350">
<img src="https://jenly1314.github.io/image/pay/alipay.png" width="280" heght="350">
<img src="https://jenly1314.github.io/image/pay/qqpay.png" width="280" heght="350">
<img src="https://jenly1314.github.io/image/alipay_red_envelopes.jpg" width="233" heght="350">
</div>

## 关于我
Name: <a title="关于作者" href="https://about.me/jenly1314" target="_blank">Jenly</a>

Email: <a title="欢迎邮件与我交流" href="mailto:jenly1314@gmail.com" target="_blank">jenly1314#gmail.com</a> / <a title="给我发邮件" href="mailto:jenly1314@vip.qq.com" target="_blank">jenly1314#vip.qq.com</a>

CSDN: <a title="CSDN博客" href="http://blog.csdn.net/jenly121" target="_blank">jenly121</a>

CNBlogs: <a title="博客园" href="https://www.cnblogs.com/jenly" target="_blank">jenly</a>

GitHub: <a title="GitHub开源项目" href="https://github.com/jenly1314" target="_blank">jenly1314</a>

Gitee: <a title="Gitee开源项目" href="https://gitee.com/jenly1314" target="_blank">jenly1314</a>

加入QQ群: <a title="点击加入QQ群" href="http://shang.qq.com/wpa/qunwpa?idkey=8fcc6a2f88552ea44b1411582c94fd124f7bb3ec227e2a400dbbfaad3dc2f5ad" target="_blank">20867961</a>
   <div>
       <img src="https://jenly1314.github.io/image/jenly666.png">
       <img src="https://jenly1314.github.io/image/qqgourp.png">
   </div>