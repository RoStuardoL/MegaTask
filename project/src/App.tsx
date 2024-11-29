import React from 'react';
import { BrowserRouter, Routes, Route, Navigate } from 'react-router-dom';
import Layout from './components/Layout';
import Login from './pages/Login';

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/login" element={<Login />} />
        <Route path="/" element={<Layout />}>
          <Route index element={<Navigate to="/customers" replace />} />
          <Route
            path="customers"
            element={<div>Customers page (to be implemented)</div>}
          />
          <Route path="users" element={<div>Users page (to be implemented)</div>} />
        </Route>
      </Routes>
    </BrowserRouter>
  );
}

export default App;