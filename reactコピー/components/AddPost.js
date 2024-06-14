import React, { useState } from 'react';
import axios from 'axios';

const AddPost = () => {
    const [title, setTitle] = useState('');
    const [category,setCategory] = useState('');
    const [city,setCity] = useState('');
    const [house,setHouse] = useState('');
    const [link,setLink] = useState('');
    const [summary,setSummary] = useState('');
    const [content, setContent] = useState('');
    const [image, setImage] = useState(null);

    const handleSubmit = async (event) => {
        event.preventDefault();
        const formData = new FormData();
        formData.append('title', title);
        formData.append('content', content);
        if (image) {
            formData.append('image', image);
        }

        try {
            await axios.post('/api/posts', formData, {
                headers: {
                    'Content-Type': 'multipart/form-data',
                },
            });
            alert('Post added successfully!');
        } catch (error) {
            console.error('There was an error adding the post!', error);
        }
    };

    return (
        <form onSubmit={handleSubmit}>
            <div>
                <label>タイトル:</label>
                <input type="text" value={title} onChange={(e) => setTitle(e.target.value)} required />
            </div>
            <div>
                <label>カテゴリ:</label>
                <input type="text" value={category} onChange={(e) => setCategory(e.target.value)} required />
            </div>
            <div>
                <label>市町村:</label>
                <textarea value={city} onChange={(e) => setCity(e.target.value)} required />
            </div>
            <div>
                <label>番地:</label>
                <textarea value={house} onChange={(e) => setHouse(e.target.value)} required />
            </div>
            <div>
                <label>画像1:</label>
                <input type="file" onChange={(e) => setImage(e.target.files[0])} accept=".png,.jpg,.jpeg"/>
            </div>
            <div>
                <label>画像2:</label>
                <input type="file" onChange={(e) => setImage(e.target.files[1])} accept=".png,.jpg,.jpeg"/>
            </div>
            <div>
                <label>画像3:</label>
                <input type="file" onChange={(e) => setImage(e.target.files[2])} accept=".png,.jpg,.jpeg"/>
            </div>
            <div>
                <label>画像4:</label>
                <input type="file" onChange={(e) => setImage(e.target.files[3])} accept=".png,.jpg,.jpeg"/>
            </div>
            <div>
                <label>画像5:</label>
                <input type="file" onChange={(e) => setImage(e.target.files[4])} accept=".png,.jpg,.jpeg"/>
            </div>
            <div>
                <label>外部リンク:</label>
                <textarea value={link} onChange={(e) => setLink(e.target.value)} required />
            </div>
            <div>
                <label>概要:</label>
                <textarea value={summary} onChange={(e) => setSummary(e.target.value)} required />
            </div>
            <div>
                <label>詳細:</label>
                <textarea value={content} onChange={(e) => setContent(e.target.value)} required />
            </div>
            <button type="submit">投稿</button>
        </form>
    );
};

export default AddPost;