# 实验二：Android 界面布局

《移动软件开发》实验二。通过四个界面任务，练习 Android 传统 View 体系下的
三种经典布局方式：**LinearLayout（线性布局）、TableLayout（表格布局）、
ConstraintLayout（约束布局）**。

## 一、实验目的

1. 掌握声明式布局的写法：在 XML 中描述界面，而不是用代码硬编码
2. 掌握 `LinearLayout` 的 `orientation` 与 `layout_weight` 权重分配机制
3. 掌握 `TableLayout` / `TableRow` 的表格模型与列拉伸、跨列
4. 掌握 `ConstraintLayout` 的相对约束、Guideline 百分比辅助线与 Chain 链
5. 学会用 shape drawable 自绘控件背景，理解"扁平结构优于深层嵌套"

## 二、开发环境

| 项目 | 版本 |
| :--- | :--- |
| Android Studio | 2026.1.3 |
| 语言 / UI | **Java + XML（View 体系）** |
| compileSdk / targetSdk | 37 |
| minSdk | 24 |
| Gradle / AGP | 9.5.0 / 9.3.0 |

## 三、实验内容与实现

### 任务 1 · 线性布局（LinearLayout）

复刻课件示例：黑底描边的 4×4 格子（`One,One` ~ `Four,Four`），**第二列明显更宽**。

- `activity_linear.xml`：外层竖直 `LinearLayout` 用 `layout_weight=1` 均分四行；
  每行再嵌一个水平 `LinearLayout`，四个 `TextView` 用 `layout_weight` 分配宽度，
  第二列 `weight=2`，其余为 1 —— 一行代码完成"1:2:1:1"的列宽比例
- 格子背景 `bg_cell.xml`：shape drawable（黑色填充 + 灰色描边），无需任何图片资源

### 任务 2 · 表格布局（TableLayout）

复刻 Android 官方文档的 **"Hello TableLayout"** 菜单界面。

- `activity_table.xml`：`TableLayout` + 6 个 `TableRow`；`stretchColumns="1"`
  把快捷键列拉伸到行尾，实现 `Open…  Ctrl-O` 这种左右对齐效果
- 用两条 `View` 分隔线把 `Import… / Export…` 与其他菜单项隔开，
  复刻官方截图中分组分隔的样式

### 任务 3 · 约束布局 · 计算器（ConstraintLayout）

实现计算器界面：`Input` 标签 + `0.0` 显示屏 + 4 行按键（0~9、÷ × + - = .）。

- `activity_calculator.xml`：全部控件放在**一个** `ConstraintLayout` 内
- 每行 4 个按键之间用**水平链（Chain）**相互约束，实现等宽分布；
  行与行之间纵向依次约束，整屏无一处嵌套布局
- 按键圆角背景 `bg_calc_btn.xml`：shape drawable

### 任务 4 · 约束布局 · 火星航班预订页（Mars）

实现一个视觉完整的预订页：顶部标签栏 + DCA→MARS 卡片 + One Way 开关 +
DEPART 按钮 + 装饰插图（火箭 / 火星车 / 空间站 / 星系 / 箭头）。

- `activity_mars.xml`：顶部三个标签（Space Stations / Flights / Rovers）用
  **两条垂直百分比 Guideline** 精确三等分；卡片、开关、插图、按钮全部通过约束定位，
  **零嵌套布局**
- 顶部标签栏为自绘（不依赖系统 TabLayout），页面使用 `NoActionBar` 主题全屏展示
- 背景块 `bg_mars_green.xml` / `bg_mars_orange.xml` 均为 shape drawable

> 各 Activity 均已在 `AndroidManifest.xml` 中注册。当前未设置 launcher 入口，
> 通过 Android Studio 的 Run Configuration 直接指定启动某个 Activity 进行验证。

## 四、学到的知识

1. **`layout_weight` 是线性布局的比例分配利器**：宽度交给 weight 决定时，
   控件宽度应设为 `0dp`，避免先测量后分配带来的偏差
2. **表格布局的本质是"行"**：`TableLayout` 只管行（`TableRow`），列宽靠
   `stretchColumns` / `shrinkColumns` / `layout_span` 控制，单元格内的控件默认不拉伸
3. **ConstraintLayout 的三板斧**：相对约束定位、`Guideline`（可用 percent 定位）、
   `Chain`（spread / weighted）。用它可以用**一层扁平结构**画出过去需要三四层嵌套
   才能实现的界面，测量次数更少、层级更浅
4. **shape drawable 代替切图**：圆角、描边、纯色背景用 XML 描述，体积小、可随主题改色
5. **文案集中放 `strings.xml`**：布局里不写死文字，便于复用和后续多语言
6. **XML 布局的心智模型**：界面 = 描述"控件之间如何相互约束/分配"，而不是
   计算"控件在哪个像素坐标"——这是声明式 UI 与命令式绘图的分水岭

## 五、文件结构

```
layout-basics/
├── app/src/main/
│   ├── AndroidManifest.xml              # 4 个 Activity 的注册
│   ├── java/com/example/layout_basics/
│   │   ├── LinearLayoutActivity.java    # 任务1
│   │   ├── TableLayoutActivity.java     # 任务2
│   │   ├── CalculatorActivity.java      # 任务3
│   │   └── MarsActivity.java            # 任务4
│   └── res/
│       ├── layout/  activity_linear.xml · activity_table.xml
│       │            activity_calculator.xml · activity_mars.xml
│       ├── drawable/  bg_cell · bg_calc_btn · bg_mars_green/orange
│       │              ic_rocket · ic_rover · ic_space_station 等
│       └── values/  strings.xml（全部界面文案）
```

## 六、运行方式

1. Android Studio → `File` → `Open` → 选择本 `layout-basics` 文件夹
2. Gradle Sync 完成后，在 Run Configuration 的启动项里选择要查看的任务
   （如 `CalculatorActivity`），点击 Run 在模拟器上运行
