package com.example.mobilelabs

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mobilelabs.ui.theme.MobileLabsTheme

/**
 * 主页面：课程实验目录。
 * 以后每完成一个新实验，在这里的 labList 里加一条即可。
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MobileLabsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LabListScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

/** 实验条目：标题 + 副标题 + 点击后要启动的页面 */
private data class LabItem(
    val title: String,
    val subtitle: String,
    val target: Class<*>
)

// ── 实验目录：新增实验时在下面追加一条 ──────────────────────────
private val labList = listOf(
    LabItem("实验一 · Hello World", "开发基础：第一个 Android 应用（Compose）", HelloWorldActivity::class.java),
    LabItem("实验二 · 任务1 线性布局", "LinearLayout：4x4 格子，weight 分配宽度", LinearLayoutActivity::class.java),
    LabItem("实验二 · 任务2 表格布局", "TableLayout：文件菜单（Hello TableLayout）", TableLayoutActivity::class.java),
    LabItem("实验二 · 任务3 约束布局·计算器", "ConstraintLayout：水平链等宽分布按键", CalculatorActivity::class.java),
    LabItem("实验二 · 任务4 火星航班预订", "ConstraintLayout：Guideline + 百分比约束", MarsActivity::class.java),
)

@Composable
fun LabListScreen(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    Column(modifier = modifier.fillMaxSize()) {
        Text(
            text = "移动软件开发 · 实验目录",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 20.dp, top = 20.dp, bottom = 8.dp)
        )
        labList.forEach { lab ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        context.startActivity(Intent(context, lab.target))
                    }
                    .padding(horizontal = 20.dp, vertical = 14.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(Modifier.weight(1f)) {
                    Text(text = lab.title, fontSize = 17.sp, fontWeight = FontWeight.Medium)
                    Text(
                        text = lab.subtitle,
                        fontSize = 13.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
                Text(text = "›", fontSize = 24.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
            }
            HorizontalDivider()
        }
    }
}
