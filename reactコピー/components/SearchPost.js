import React, { useState } from 'react';
import axios from 'axios';

const SearchPosts = () => {
    const [keyword, setKeyword] = useState('');
    const [results, setResults] = useState([]);

    const handleSearch = async () => {
        try {
            const response = await axios.get(`/api/posts/search?keyword=${keyword}`);
            setResults(response.data);
        } catch (error) {
            console.error('There was an error searching for posts!', error);
        }
    };

    return (
        <div>
            <input type="text" value={keyword} onChange={(e) => setKeyword(e.target.value)} placeholder="Search posts..." />
            <button onClick={handleSearch}>Search</button>
            <div>
                {results.map(post => (
                    <div key={post.id}>
                        <h3>{post.title}</h3>
                        <p>{post.content}</p>
                    </div>
                ))}
            </div>
        </div>
    );
};

export default SearchPosts;