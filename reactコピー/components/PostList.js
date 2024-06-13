import React, { useState, useEffect } from 'react';
import axios from'axios';
import LikeButton from './LikeButton';
import BookmarkButton from './BookmarkButton';

const PostList = () => {
    const [posts, setPosts] = useState([]);

    useEffect(() => {
        const fetchPosts = async () => {
            const response = await axios.get('/api/posts');
            setPosts(response.data);
        };
        fetchPosts();
    }, []);

    return (
        <div>
            {posts.map(post => (
                <div key={post.id}>
                    <h3>{post.title}</h3>
                    <p>{post.content}</p>
                    <LikeButton postId={post.id} initialLiked={post.likedByUser} />
                    <BookmarkButton postId={post.id} initialBookmarked={post.bookmarkedByUser} />
                </div>
            ))}
        </div>
    );
};

export default PostList;