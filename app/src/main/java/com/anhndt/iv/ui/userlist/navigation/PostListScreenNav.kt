import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.anhndt.iv.data.api.RetrofitClient
import com.anhndt.iv.data.remote.impl.PostRepositoryImpl
import com.anhndt.iv.domain.model.PostModel
import com.anhndt.iv.domain.usecase.impl.GetPostUseCaseImpl
import com.anhndt.iv.ui.nav.RouteName
import com.anhndt.iv.ui.userlist.PostViewModel

fun NavGraphBuilder.postListScreen(
    onItemClick: (PostModel) -> Unit
) {
    val viewModel =
        PostViewModel(GetPostUseCaseImpl(PostRepositoryImpl(RetrofitClient.apiService)))
    composable(route = RouteName.PostList.route) {
        PostListRoute(
            viewModel = viewModel,
            onItemClick = onItemClick
        )
    }
}