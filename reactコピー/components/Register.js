import React, { useState } from 'react';
import axios from 'axios';

const Register = () => {
    const [username, setUsername] = useState('');
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');

    const handleSubmit = async (event) => {
        event.preventDefault();
        try {
            await axios.post('/api/users/register', { username, email, password });
            alert('Registration successful!');
        } catch (error) {
            console.error('There was an error registering!', error);
        }
    };

    return (
        <form onSubmit={handleSubmit}>
            <div>
                <label>ニックネーム:</label>
                <input type="text" value={username} onChange={(e) => setUsername(e.target.value)} required />
            </div>
            <div>
                <label>メールアドレス:</label>
                <input type="email" value={email} onChange={(e) => setEmail(e.target.value)} required />
            </div>
            <div>
                <label>パスワード</label>
                <input type="password" value={password} onChange={(e) => setPassword(e.target.value)} required />
            </div>
            <button type="submit">登録</button>

            <button type="submit">登録</button>
        </form>
    );
};

export default Register;