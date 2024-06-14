import React, { useState, useEffect } from 'react';
import axios from 'axios';

const UserManagement = () => {
    const [users, setUsers] = useState([]);

    useEffect(() => {
        const fetchUsers = async () => {
            const response = await axios.get('/api/admin/users');
            setUsers(response.data);
        };
        fetchUsers();
    }, []);

    const handleDeleteUser = async (userId) => {
        try {
            await axios.delete(`/api/admin/users/${userId}`);
            setUsers(users.filter(user => user.id !== userId));
        } catch (error) {
            console.error('There was an error deleting the user!', error);
        }
    };

    const handleUpdateUser = async (userId, userDetails) => {
        try {
            const response = await axios.put(`/api/admin/users/${userId}`, userDetails);
            setUsers(users.map(user => (user.id === userId ? response.data : user)));
        } catch (error) {
            console.error('There was an error updating the user!', error);
        }
    };

    return (
        <div>
            <h2>User Management</h2>
            {users.map(user => (
                <div key={user.id}>
                    <h3>{user.username}</h3>
                    <p>{user.email}</p>
                    <button onClick={() => handleUpdateUser(user.id, user)}>Edit</button>
                    <button onClick={() => handleDeleteUser(user.id)}>Delete</button>
                </div>
            ))}
        </div>
    );
};

export default UserManagement;
