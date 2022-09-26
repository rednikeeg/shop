import React, {useEffect, useState} from 'react';
import API from './../constants.js';
import axios from 'axios';
import {useParams} from "react-router-dom";

export function ItemList(props) {
    let {id} = useParams();
    const [items, setItems] = useState([]);
    useEffect(() => {
        if (props.all) {
            axios.get(API + "item/get/all/")
                .then(response => setItems(response.data));
        } else {
            axios.get(API + "item/getByCategoryId/" + id)
                .then(response => setItems(response.data));
        }
    }, [])

    return <ul>
        {items.map((item, index) => <Item key={index} item={item}/>)}
    </ul>
}

function Item(props) {
    return <li className="list-element item-element">
        <p>Name : {props.item.name}</p>
        <p>Desc : {props.item.description}</p>
        <p>Category : {props.item.category.name}</p>
    </li>
}