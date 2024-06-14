import React, { useState, useEffect } from 'react';
import axios from 'axios';

const AnnouncementManagement = () => {
    const [announcements, setAnnouncements] = useState([]);
    const [newAnnouncement, setNewAnnouncement] = useState('');

    useEffect(() => {
        const fetchAnnouncements = async () => {
            const response = await axios.get('/api/admin/announcements');
            setAnnouncements(response.data);
        };
        fetchAnnouncements();
    }, []);

    const handleAddAnnouncement = async () => {
        try {
            const response = await axios.post('/api/admin/announcements', { message: newAnnouncement });
            setAnnouncements([...announcements, response.data]);
            setNewAnnouncement('');
        } catch (error) {
            console.error('There was an error adding the announcement!', error);
        }
    };

    return (
        <div>
            <h2>Announcement Management</h2>
            <input
                type="text"
                value={newAnnouncement}
                onChange={(e) => setNewAnnouncement(e.target.value)}
                placeholder="New announcement message"
            />
            <button onClick={handleAddAnnouncement}>Add Announcement</button>
            <ul>
                {announcements.map(announcement => (
                    <li key={announcement.id}>
                        {announcement.message} (Posted on: {announcement.createdAt})
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default AnnouncementManagement;
