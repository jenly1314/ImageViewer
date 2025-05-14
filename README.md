# ImageViewer

![Image](app/src/main/ic_launcher-web.png)

[![MavenCentral](https://img.shields.io/maven-central/v/com.github.jenly1314/imageviewer?logo=sonatype)](https://repo1.maven.org/maven2/com/github/jenly1314/ImageViewer)
[![JitPack](https://img.shields.io/jitpack/v/github/jenly1314/ImageViewer?logo=jitpack)](https://jitpack.io/#jenly1314/ImageViewer)
[![CI](https://img.shields.io/github/actions/workflow/status/jenly1314/ImageViewer/build.yml?logo=github)](https://github.com/jenly1314/ImageViewer/actions/workflows/build.yml)
[![Download](https://img.shields.io/badge/download-APK-brightgreen?logo=github)](https://raw.githubusercontent.com/jenly1314/ImageViewer/master/app/release/app-release.apk)
[![API](https://img.shields.io/badge/API-21%2B-brightgreen?logo=android)](https://developer.android.com/guide/topics/manifest/uses-sdk-element#ApiLevels)
[![License](https://img.shields.io/github/license/jenly1314/ImageViewer?logo=open-source-initiative)](https://opensource.org/licenses/mit)


ImageViewer for Android 是一个图片查看器，一般用来查看图片详情或查看大图时使用。

## 效果展示

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

2. 在Module的 **build.gradle** 中添加依赖项

    ```gradle
    implementation 'com.github.jenly1314:imageviewer:1.2.0'
    ```

## 使用

### 相关说明

* 使用 **ImageViewer** 时，必须配置一个实现的 **ImageLoader**。

* **ImageViewer** 一次可以查看多张图片或单张图片，支持的类型可以是 **Uri**、 **url** 、 **filePath** 、 **File**、 **DrawableRes**、 **ImageDataSource** 等。

* 目前内置默认实现 **ImageLoader** 的有 **CoilImageLoader** 、 **GlideImageLoader** 和 **PicassoImageLoader** ，三者选其一即可，如果以上都不满足您的需求，您也可以自己实现一个 **ImageLoader** 。

* 为了保证 **ImageViewer** 体积最小化，让用户有更多选择的可能性， **ImageViewer** 仅编译时用到了 **coil** 、**Glide** 和 **Picasso** 。

> 当你使用了 **CoilImageLoader** 时，则需依赖[ **COIL** ](https://github.com/coil-kt/coil)库 （v1.2.0新增）

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
> 当设置了全局默认的图片加载器后，就可以在使用`ImageViewer`实例时，不用再单独调用`imageViewer.imageLoader(imageLoader)`去设置图片加载器了。


更多使用详情，请查看[app](app)中的源码使用示例或直接查看 [API帮助文档](https://jenly1314.github.io/ImageViewer/api/)

## 相关推荐
- [DrawBoard](https://github.com/jenly1314/DrawBoard) 一个自定义View实现的画板；方便对图片进行编辑和各种涂鸦相关操作。
- [CircleProgressView](https://github.com/jenly1314/CircleProgressView) 一个圆形的进度动画控件，动画效果纵享丝滑。
- [ArcSeekBar](https://github.com/jenly1314/ArcSeekBar) 一个弧形的拖动条进度控件，配置参数完全可定制化。
- [SpinCounterView](https://github.com/jenly1314/SpinCounterView) 一个类似码表变化的旋转计数器动画控件。
- [CounterView](https://github.com/jenly1314/CounterView) 一个数字变化效果的计数器视图控件。
- [RadarView](https://github.com/jenly1314/RadarView) 一个雷达扫描动画后，然后展示得分效果的控件。
- [SuperTextView](https://github.com/jenly1314/SuperTextView) 一个在TextView的基础上扩展了几种动画效果的控件。
- [LoadingView](https://github.com/jenly1314/LoadingView) 一个圆弧加载过渡动画，圆弧个数，大小，弧度，渐变颜色，完全可配。
- [WaveView](https://github.com/jenly1314/WaveView) 一个水波纹动画控件视图，支持波纹数，波纹振幅，波纹颜色，波纹速度，波纹方向等属性完全可配。
- [GiftSurfaceView](https://github.com/jenly1314/GiftSurfaceView) 一个适用于直播间送礼物拼图案的动画控件。
- [FlutteringLayout](https://github.com/jenly1314/FlutteringLayout) 一个适用于直播间点赞桃心飘动效果的控件。
- [DragPolygonView](https://github.com/jenly1314/DragPolygonView) 一个支持可拖动多边形，支持通过拖拽多边形的角改变其形状的任意多边形控件。
- [compose-component](https://github.com/jenly1314/compose-component) 一个Jetpack Compose的组件库；主要提供了一些小组件，便于快速使用。

<!-- end -->

## 版本日志

#### v1.2.0：2024-12-6
* 代码全部改为使用`kotlin`
* 更新Gradle至v8.0
* 更新compileSdk至32
* 提升minSdk至21
* 新增`CoilImageLoader`
* 新增全局设置图片加载器函数 `ImageViewer.setGlobalDefaultImageLoader(imageLoader)`

#### [查看更多版本日志](CHANGELOG.md)

---

![footer](https://jenly1314.github.io/page/footer.svg)
