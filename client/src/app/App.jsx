import './App.css';
import React from 'react';
import {BrowserRouter as Router, Link, Route, Routes} from "react-router-dom";
import {CategoryForm, CategoryList} from "./category/Category";
import {ItemList} from "./item/Item";

export default class App extends React.Component {
    constructor(props) {
        super(props);
    }

    render() {
        return <div className="App">
            <Router>
                <div>
                    <nav>
                        <ul>
                            <li className="navbar-element"><Link to="/">Home</Link></li>
                            <li className="navbar-element"><Link to="/categories/">Explore categories</Link></li>
                            <li className="navbar-element"><Link to="/categories/create">Create new Category</Link></li>
                            <li className="navbar-element"><Link to="/items/">Explore all the items</Link></li>
                            <li className="navbar-element"><Link to="/items/create">Create new item</Link></li>
                        </ul>
                    </nav>
                    <Routes>
                        <Route path="/" element={<HomeComponent/>}/>
                        <Route path="/categories/" element={<CategoryList/>}/>
                        <Route path="/categories/create" element={<CategoryForm isPost={true}/>}/>
                        <Route path="/categories/:id" element={<ItemList all={false}/>}/>
                        <Route path="/items/" element={<ItemList all={true}/>}/>
                    </Routes>
                </div>
            </Router>
        </div>
    }
}

class HomeComponent extends React.Component {
    render() {
        return <h2>Home</h2>
    }
}
