import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.anhndt.iv.domain.model.PostModel
import com.anhndt.iv.ui.detail.PostDetail

@Composable
fun PostDetailRoute(
    onBackPress: () -> Unit,
    data: PostModel,
) {
    PostDetail(modifier = Modifier, data = data, onBackPress = onBackPress)
}