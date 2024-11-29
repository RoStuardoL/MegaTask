import { create } from 'zustand';
import { User } from '../types';

interface AuthState {
  user: User | null;
  isAuthenticated: boolean;
  login: (email: string, password: string) => Promise<void>;
  logout: () => void;
}

export const useAuthStore = create<AuthState>((set) => ({
  user: null,
  isAuthenticated: false,
  login: async (email: string, password: string) => {
    // Mock login - replace with actual API call
    if (email === 'admin@example.com' && password === 'admin') {
      set({
        user: {
          id: '1',
          email: 'admin@example.com',
          name: 'Admin User',
          role: 'admin',
        },
        isAuthenticated: true,
      });
    } else if (email === 'user@example.com' && password === 'user') {
      set({
        user: {
          id: '2',
          email: 'user@example.com',
          name: 'Regular User',
          role: 'user',
        },
        isAuthenticated: true,
      });
    } else {
      throw new Error('Invalid credentials');
    }
  },
  logout: () => {
    set({ user: null, isAuthenticated: false });
  },
}));