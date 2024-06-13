import React, { useState } from 'react';
import axios from 'axios';

const Login = () => {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');

    const handleSubmit = async (event) => {
        event.preventDefault();
        try {
            await axios.post('/api/users/login', { username, password });
            alert('Login successful!');
        } catch (error) {
            console.error('There was an error logging in!', error);
        }
    };

    return (
        <form onSubmit={handleSubmit}>
            <div>
                <label>ユーザー名:</label>
                <input type="text" value={username} onChange={(e) => setUsername(e.target.value)} required />
            </div>
            <div>
                <label>パスワード:</label>
                <input type="password" value={password} onChange={(e) => setPassword(e.target.value)} required />
            </div>
            <button type="submit">Login</button>
            <button type="submit">新規登録</button>
        </form>
    );
};

export default Login;