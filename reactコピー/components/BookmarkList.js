import React, { useEffect, useState } from 'react';
import axios from 'axios';

const BookmarkList = () => {
    const [bookmarks, setBookmarks] = useState([]);

    useEffect(() => {
        const fetchBookmarks = async () => {
            try {
                const response = await axios.get('/api/bookmarks');
                setBookmarks(response.data);
            } catch (error) {
                console.error("Error fetching bookmarks:", error);
            }
        };
        fetchBookmarks();
    }, []);

    return (
        <div>
            <h2>ブックマーク一覧</h2>
            {bookmarks.map(bookmark => (
                <div key={bookmark.id}>
                    <h3>{bookmark.post.title}</h3>
                    <p>{bookmark.post.content}</p>
                </div>
            ))}
        </div>
    );
};

export default BookmarkList;
