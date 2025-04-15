import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.anhndt.iv.domain.model.PostModel
import com.anhndt.iv.ui.nav.RouteName

fun NavGraphBuilder.postListScreen(
    onItemClick: (PostModel) -> Unit
) {
    composable(route = RouteName.PostList.route) {
        PostListRoute(
            viewModel = hiltViewModel(),
            onItemClick = onItemClick
        )
    }
}