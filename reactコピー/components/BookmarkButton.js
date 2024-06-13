import React, { useState } from 'react';
import axios from 'axios';

const BookmarkButton = ({ postId, initialBookmarked }) => {
    const [bookmarked, setBookmarked] = useState(initialBookmarked);
    const [loading, setLoading] = useState(false);

    const handleBookmark = async () => {
        setLoading(true);
        try {
            if (bookmarked) {
                await axios.delete(`/api/bookmarks/${postId}`);
            } else {
                await axios.post(`/api/bookmarks/${postId}`);
            }
            setBookmarked(!bookmarked);
        } catch (error) {
            console.error("Error bookmarking/unbookmarking post:", error);
        } finally {
            setLoading(false);
        }
    };

    return (
        <button onClick={handleBookmark} disabled={loading}>
            {bookmarked ? "Unbookmark" : "Bookmark"}
        </button>
    );
};

export default BookmarkButton;
