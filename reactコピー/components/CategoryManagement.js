import React, { useState, useEffect } from 'react';
import axios from 'axios';

const CategoryManagement = () => {
    const [categories, setCategories] = useState([]);
    const [newCategory, setNewCategory] = useState('');
    const [editCategory, setEditCategory] = useState(null);

    useEffect(() => {
        const fetchCategories = async () => {
            const response = await axios.get('/api/admin/categories');
            setCategories(response.data);
        };
        fetchCategories();
    }, []);

    const handleAddCategory = async () => {
        try {
            const response = await axios.post('/api/admin/categories', { name: newCategory });
            setCategories([...categories, response.data]);
            setNewCategory('');
        } catch (error) {
            console.error('There was an error adding the category!', error);
        }
    };

    const handleUpdateCategory = async (category) => {
        try {
            const response = await axios.put(`/api/admin/categories/${category.id}`, category);
            setCategories(categories.map(cat => (cat.id === category.id ? response.data : cat)));
            setEditCategory(null);
        } catch (error) {
            console.error('There was an error updating the category!', error);
        }
    };

    const handleDeleteCategory = async (categoryId) => {
        try {
            await axios.delete(`/api/admin/categories/${categoryId}`);
            setCategories(categories.filter(cat => cat.id !== categoryId));
        } catch (error) {
            console.error('There was an error deleting the category!', error);
        }
    };

    return (
        <div>
            <h2>Category Management</h2>
            <input
                type="text"
                value={newCategory}
                onChange={(e) => setNewCategory(e.target.value)}
                placeholder="New category name"
            />
            <button onClick={handleAddCategory}>Add Category</button>
            <ul>
                {categories.map(category => (
                    <li key={category.id}>
                        {editCategory === category.id ? (
                            <>
                                <input
                                    type="text"
                                    value={category.name}
                                    onChange={(e) => setEditCategory({ ...category, name: e.target.value })}
                                />
                                <button onClick={() => handleUpdateCategory(editCategory)}>Save</button>
                            </>
                        ) : (
                            <>
                                {category.name}
                                <button onClick={() => setEditCategory(category)}>Edit</button>
                                <button onClick={() => handleDeleteCategory(category.id)}>Delete</button>
                            </>
                        )}
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default CategoryManagement;
