import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.anhndt.iv.domain.model.PostModel
import com.anhndt.iv.ui.nav.RouteName
import com.google.gson.Gson

fun NavGraphBuilder.postDetailScreen(
    onBackPress: () -> Unit
) {
    composable(
        route = RouteName.PostDetail.route,
    ) { backStackEntry ->
        val itemJson = backStackEntry.arguments?.getString("item")
        val item = Gson().fromJson(itemJson, PostModel::class.java)
        PostDetailRoute(
            onBackPress = onBackPress,
            data = item
        )
    }
}