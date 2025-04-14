import androidx.compose.runtime.Composable
import com.anhndt.iv.domain.model.PostModel
import com.anhndt.iv.ui.userlist.PostList
import com.anhndt.iv.ui.userlist.PostViewModel

@Composable
fun PostListRoute(
    viewModel: PostViewModel,
    onItemClick: (PostModel) -> Unit
) {
    PostList(
        viewModel = viewModel,
        onItemClick = onItemClick,
    )
}