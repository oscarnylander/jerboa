package com.jerboa.ui.components.comment

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import com.jerboa.CommentNodeData
import com.jerboa.datatypes.CommentView
import com.jerboa.datatypes.CommunityModeratorView
import com.jerboa.datatypes.CommunitySafe
import com.jerboa.datatypes.PersonSafe
import com.jerboa.db.Account

@Composable
fun CommentNodes(
    nodes: List<CommentNodeData>,
    isFlat: Boolean,
    listState: LazyListState,
    onUpvoteClick: (commentView: CommentView) -> Unit,
    onDownvoteClick: (commentView: CommentView) -> Unit,
    onReplyClick: (commentView: CommentView) -> Unit,
    onSaveClick: (commentView: CommentView) -> Unit,
    onMarkAsReadClick: (commentView: CommentView) -> Unit,
    onEditCommentClick: (commentView: CommentView) -> Unit,
    onDeleteCommentClick: (commentView: CommentView) -> Unit,
    onReportClick: (commentView: CommentView) -> Unit,
    onCommentLinkClick: (commentView: CommentView) -> Unit,
    onFetchChildrenClick: (commentView: CommentView) -> Unit,
    onPersonClick: (personId: Int) -> Unit,
    onCommunityClick: (community: CommunitySafe) -> Unit,
    onBlockCreatorClick: (creator: PersonSafe) -> Unit,
    onPostClick: (postId: Int) -> Unit,
    account: Account? = null,
    moderators: List<CommunityModeratorView>,
    showPostAndCommunityContext: Boolean = false
) {
    // Holds the un-expanded comment ids
    val unExpandedComments = remember { mutableStateListOf<Int>() }

    LazyColumn(state = listState) {
        commentNodeItems(
            nodes = nodes,
            isFlat = isFlat,
            isExpanded = { commentId -> !unExpandedComments.contains(commentId) },
            toggleExpanded = { commentId ->
                if (unExpandedComments.contains(commentId)) {
                    unExpandedComments.remove(commentId)
                } else {
                    unExpandedComments.add(commentId)
                }
            },
            onUpvoteClick = onUpvoteClick,
            onDownvoteClick = onDownvoteClick,
            onReplyClick = onReplyClick,
            onSaveClick = onSaveClick,
            account = account,
            moderators = moderators,
            onMarkAsReadClick = onMarkAsReadClick,
            onPersonClick = onPersonClick,
            onCommunityClick = onCommunityClick,
            onPostClick = onPostClick,
            onEditCommentClick = onEditCommentClick,
            onDeleteCommentClick = onDeleteCommentClick,
            onReportClick = onReportClick,
            onCommentLinkClick = onCommentLinkClick,
            onFetchChildrenClick = onFetchChildrenClick,
            onBlockCreatorClick = onBlockCreatorClick,
            showPostAndCommunityContext = showPostAndCommunityContext
        )
    }
}

fun LazyListScope.commentNodeItems(
    nodes: List<CommentNodeData>,
    isFlat: Boolean,
    isExpanded: (commentId: Int) -> Boolean,
    toggleExpanded: (commentId: Int) -> Unit,
    onUpvoteClick: (commentView: CommentView) -> Unit,
    onDownvoteClick: (commentView: CommentView) -> Unit,
    onReplyClick: (commentView: CommentView) -> Unit,
    onSaveClick: (commentView: CommentView) -> Unit,
    onMarkAsReadClick: (commentView: CommentView) -> Unit,
    onEditCommentClick: (commentView: CommentView) -> Unit,
    onDeleteCommentClick: (commentView: CommentView) -> Unit,
    onReportClick: (commentView: CommentView) -> Unit,
    onCommentLinkClick: (commentView: CommentView) -> Unit,
    onFetchChildrenClick: (commentView: CommentView) -> Unit,
    onPersonClick: (personId: Int) -> Unit,
    onCommunityClick: (community: CommunitySafe) -> Unit,
    onBlockCreatorClick: (creator: PersonSafe) -> Unit,
    onPostClick: (postId: Int) -> Unit,
    account: Account? = null,
    moderators: List<CommunityModeratorView>,
    showPostAndCommunityContext: Boolean = false
) {
    nodes.forEach { node ->
        commentNodeItem(
            node = node,
            isFlat = isFlat,
            isExpanded = isExpanded,
            toggleExpanded = toggleExpanded,
            onUpvoteClick = onUpvoteClick,
            onDownvoteClick = onDownvoteClick,
            onReplyClick = onReplyClick,
            onSaveClick = onSaveClick,
            account = account,
            moderators = moderators,
            onMarkAsReadClick = onMarkAsReadClick,
            onPersonClick = onPersonClick,
            onCommunityClick = onCommunityClick,
            onPostClick = onPostClick,
            onEditCommentClick = onEditCommentClick,
            onDeleteCommentClick = onDeleteCommentClick,
            onReportClick = onReportClick,
            onCommentLinkClick = onCommentLinkClick,
            onFetchChildrenClick = onFetchChildrenClick,
            onBlockCreatorClick = onBlockCreatorClick,
            showPostAndCommunityContext = showPostAndCommunityContext
        )
    }
}
