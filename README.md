# 移动软件开发 · 课程实验

本仓库用于存放《移动软件开发》课程的实验代码。

**结构约定**：整门课的实验都在**一个 Android 工程** `mobile-labs/` 里。
运行 App 后，主页面是**实验目录列表**，点击任意条目即可跳转到对应实验页面。
以后每完成一个新实验，只需在 `MainActivity.kt` 的 `labList` 里追加一条即可。

## 实验索引

| 实验 | 页面（Activity） | 主要内容 |
| :---: | :--- | :--- |
| 一 | `HelloWorldActivity` | 开发基础：第一个 Android 应用（Compose） |
| 二 · 任务1 | `LinearLayoutActivity` | 线性布局：4x4 格子，weight 分配宽度 |
| 二 · 任务2 | `TableLayoutActivity` | 表格布局：文件菜单（Hello TableLayout） |
| 二 · 任务3 | `CalculatorActivity` | 约束布局：水平链等宽分布的计算器按键 |
| 二 · 任务4 | `MarsActivity` | 约束布局：Guideline + 百分比约束的火星航班预订页 |

## 开发环境

| 项目 | 版本 |
| :--- | :--- |
| Android Studio | 2026.1.3 |
| 语言 / UI | Kotlin + Jetpack Compose（主页面、实验一）；Java + XML / View 体系（实验二起） |
| AGP / Kotlin / Gradle | 9.3.0 / 2.2.10 / 9.5.0 |
| compileSdk / targetSdk | 37 |
| minSdk | 24 |
| JDK | 11 (source / target) |

## 如何运行

1. Android Studio → `File` → `Open`
2. 选中 **`mobile-labs` 文件夹**（这是唯一的工程目录）
3. 等待 Gradle Sync 完成后点击 Run
4. 主页面出现实验目录列表，点击条目进入对应实验页面

## 如何添加新实验

1. 在 `app/src/main/java/com/example/mobilelabs/` 下新建实验的 Activity（Java 或 Kotlin 均可）
2. 在 `AndroidManifest.xml` 中注册该 Activity
3. 在 `MainActivity.kt` 的 `labList` 中追加一条 `LabItem(...)`
4. 重新编译运行，主页面列表里就会出现新实验入口
