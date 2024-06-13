import React, { useState, useEffect } from 'react';
import axios from 'axios';

const PostManagement = () => {
    const [posts, setPosts] = useState([]);

    useEffect(() => {
        const fetchPosts = async () => {
            const response = await axios.get('/api/posts');
            setPosts(response.data);
        };
        fetchPosts();
    }, []);

    const handleDeletePost = async (postId) => {
        try {
            await axios.delete(`/api/admin/posts/${postId}`);
setPosts(posts.filter(post => post.id !== postId));
} catch (error) {
console.error('テストエラー', error);
}
};

const handleUpdatePost = async (postId, postDetails) => {
    try {
        const response = await axios.put(`/api/admin/posts/${postId}`, postDetails);
        setPosts(posts.map(post => (post.id === postId ? response.data : post)));
    } catch (error) {
        console.error("", error);
    }
};

return (
    <div>
        <h2>Post Management</h2>
        {posts.map(post => (
            <div key={post.id}>
                <h3>{post.title}</h3>
                <p>{post.content}</p>
                <button onClick={() => handleUpdatePost(post.id, post)}>Edit</button>
                <button onClick={() => handleDeletePost(post.id)}>Delete</button>
            </div>
        ))}
    </div>
);
};
export default PostManagement;
