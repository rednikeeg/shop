import React from 'react';
import axios from "axios";
import API from "../constants";
import {Link} from "react-router-dom";

export class CategoryList extends React.Component {
    constructor(props) {
        super(props);

        this.state = {categories: []};
    }

    componentDidMount() {
        this.getAllCategories()
    }

    getAllCategories() {
        axios.get(API + "category/get/all")
            .then(response => this.setState({categories: response.data}));
    }

    render() {
        return <ul>
            {this.state.categories.map((category, index) => (
                <Category key={index} category={category}/>
            ))}
        </ul>
    }
}

function Category(props) {
    return <li className="list-element category-element">
        <Link to={":" + props.category.id}>
            <p>Name : {props.category.name}</p>
            <p>Desc : {props.category.description}</p>
        </Link>
    </li>
}

export class CategoryForm extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            isPost: props.isPost,
            id: props.id,
            categoryName: '',
            categoryDescription: ''
        };

        this.onChange = this.onChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    onChange(event, field) {
        const value = event.target.value;

        this.setState({[field]: value});

        event.preventDefault();
    }

    create() {
        axios.post(
            API + 'category/create',
            {
                name: this.state.categoryName,
                description: this.state.categoryDescription
            }
        ).then(response => console.log(response.data));
    }

    update() {
        axios.put(
            API + 'category/update',
            {
                id: this.state.id,
                name: this.state.categoryName,
                description: this.state.categoryDescription
            }
        ).then(response => console.log(response.data));
    }

    handleSubmit(event) {
        this.state.isPost ? this.create() : this.update();
        event.preventDefault();
    }

    isNotValid() {
        return (this.state.isPost == null || (this.state.isPost !== true && this.state.id == null));
    }

    render() {
        return (
            <form className="category-form" onSubmit={this.handleSubmit}>
                <label>Name</label> <br/>
                <input type="text" value={this.state.categoryName}
                       onChange={e => this.onChange(e, 'categoryName')}/> <br/>
                <label>Description</label> <br/>
                <input type="text" value={this.state.categoryDescription}
                       onChange={e => this.onChange(e, 'categoryDescription')}/> <br/>
                <input type="submit" value="Submit"/>
            </form>
        )
    }
}
