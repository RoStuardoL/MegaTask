import React from 'react';
import { Link, useNavigate } from 'react-router-dom';
import { Users, LogOut } from 'lucide-react';
import { useAuthStore } from '../store/auth';

export default function Navbar() {
  const { user, logout } = useAuthStore();
  const navigate = useNavigate();

  const handleLogout = () => {
    logout();
    navigate('/login');
  };

  return (
    <nav className="bg-white shadow">
      <div className="container mx-auto px-4">
        <div className="flex justify-between items-center h-16">
          <div className="flex items-center space-x-8">
            <Link to="/" className="flex items-center space-x-2">
              <Users className="h-6 w-6 text-blue-600" />
              <span className="font-semibold text-xl">CMS</span>
            </Link>
            <div className="hidden md:flex space-x-4">
              <Link
                to="/customers"
                className="text-gray-700 hover:text-blue-600 px-3 py-2 rounded-md"
              >
                Customers
              </Link>
              {user?.role === 'admin' && (
                <Link
                  to="/users"
                  className="text-gray-700 hover:text-blue-600 px-3 py-2 rounded-md"
                >
                  Users
                </Link>
              )}
            </div>
          </div>
          <div className="flex items-center space-x-4">
            <span className="text-gray-700">{user?.name}</span>
            <button
              onClick={handleLogout}
              className="flex items-center space-x-1 text-gray-700 hover:text-blue-600"
            >
              <LogOut className="h-5 w-5" />
              <span>Logout</span>
            </button>
          </div>
        </div>
      </div>
    </nav>
  );
}