import React, { useState, useEffect } from 'react';
import axios from 'axios';

const UserProfile = ({ username }) => {
    const [user, setUser] = useState({});
    const [posts, setPosts] = useState([]);

    useEffect(() => {
        const fetchUser = async () => {
            try {
                const userResponse = await axios.get(`/api/users/${username}`);
                setUser(userResponse.data);
            } catch (error) {
                console.error('There was an error fetching the user!', error);
            }
        };
        const fetchPosts = async () => {
            try {
                const postsResponse = await axios.get(`/api/posts/user/${username}`);
                setPosts(postsResponse.data);
            } catch (error) {
                console.error('There was an error fetching the posts!', error);
            }
        };
        fetchUser();
        fetchPosts();
    }, [username]);

    const handleDeleteAccount = async () => {
        try {
            await axios.delete(`/api/users/${username}`);
            alert('Account deleted successfully!');
        } catch (error) {
            console.error('There was an error deleting the account!', error);
        }
    };

    const handleUpdateProfile = async () => {
        try {
            await axios.put(`/api/users/${username}`, user);
            alert('Profile updated successfully!');
        } catch (error) {
            console.error('There was an error updating the profile!', error);
        }
    };

    return (
        <div>
            <h2>プロフィール</h2>
            <div>
                <label>ニックネーム:</label>
                <input type="text" value={user.username} onChange={(e) => setUser({ ...user, username: e.target.value })} />
            </div>
            <div>
                <label>メールアドレス:</label>
                <input type="email" value={user.email} onChange={(e) => setUser({ ...user, email: e.target.value })} />
            </div>
            <div>
                <label>プロフィール画像:</label>
                <input type="text" value={user.profilePicture} onChange={(e) => setUser({ ...user, profilePicture: e.target.value })} />
            </div>
            <button onClick={handleUpdateProfile}>プロフィール更新</button>
            <button onClick={handleDeleteAccount}>アカウント削除</button>

            <h3>投稿</h3>
            {posts.map(post => (
                <div key={post.id}>
                    <h4>{post.title}</h4>
                    <p>{post.content}</p>
                    <button>Edit</button>
                    <button>Delete</button>
                </div>
            ))}
        </div>
    );
};

export default UserProfile;