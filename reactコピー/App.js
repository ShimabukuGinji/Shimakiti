import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Login from './components/Login';
import Register from './components/Register';
import UserProfile from './components/UserProfile';
import AddPost from './components/AddPost';
import PostList from './components/PostList';
import BookmarkList from './components/BookmarkList';

function App() {
  return (
    <Router>
      <div className="App">
        <Routes>
          <Route path="/login" element={<Login />} />
          <Route path="/register" element={<Register />} />
          <Route path="/postlist" element={<PostList />} />
          <Route path="/addpost" element={<AddPost />} />
          <Route path="/bookmarklist" element={<BookmarkList />} />
          <Route path="/userprofile" element={<UserProfile />} />
          <Route path="/addpost" element={<AddPost />} />
          <Route path="/" element={<Login />} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;
