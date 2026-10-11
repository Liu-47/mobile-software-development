# 移动软件开发 · 课程实验

本仓库用于存放《移动软件开发》课程的实验代码。

**结构约定**：每次实验一个独立文件夹，每个文件夹都是一个**完整可运行的 Android 工程**，
可以用 Android Studio 单独打开。

## 实验索引

| 实验 | 文件夹 | 主要内容 | 完成日期 |
| :---: | :--- | :--- | :---: |
| 一 | [`MyFirstApplication`](./MyFirstApplication) | 开发基础：创建第一个应用、Compose 入门 | 2026-10-11 |

## 开发环境

| 项目 | 版本 |
| :--- | :--- |
| Android Studio | 2026.1.3 |
| 语言 / UI | Kotlin + Jetpack Compose (Material3) |
| compileSdk / targetSdk | 37 |
| minSdk | 24 |
| JDK | 11 (source / target) |

## 如何运行某个实验

1. Android Studio → `File` → `Open`
2. 选中**对应的实验子文件夹**（例如 `MyFirstApplication`）
3. 等待 Gradle Sync 完成后点击 Run

> ⚠️ 不要用 Android Studio 打开仓库根目录。根目录本身不是 Android 工程，
> 打开后会在根目录生成 `.gradle/`、`.idea/` 等无关文件。请始终打开具体的实验文件夹。
