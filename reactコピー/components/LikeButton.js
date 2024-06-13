import React, { useState } from 'react';
import axios from 'axios';

const LikeButton = ({ postId, initialLiked }) => {
    const [liked, setLiked] = useState(initialLiked);
    const [loading, setLoading] = useState(false);

    const handleLike = async () => {
        setLoading(true);
        try {
            if (liked) {
                await axios.delete(`/api/posts/${postId}/like`);
            } else {
                await axios.post(`/api/posts/${postId}/like`);
            }
            setLiked(!liked);
        } catch (error) {
            console.error('Error liking/unliking post:', error);
        } finally {
            setLoading(false);
        }
    };

    return (
        <button onClick={handleLike} disabled={loading}>
            {liked ? 'Unlike' : 'Like'}
        </button>
    );
};

export default LikeButton;