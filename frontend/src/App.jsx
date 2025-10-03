import axios from 'axios';
import { useEffect, useState } from 'react'

function App() {
  const [products, setProducts] = useState("");
  const [productName, setProductName] = useState("");
  const [productPrice, setProductPrice] = useState("");
  const [productID, setProductID] = useState("");

  const [updateProductID, setUpdateProductID] = useState("");
  const [updateProductName, setUpdateProductName] = useState("");
  const [updateProductPrice, setUpdateProductPrice] = useState("");
  

  const showAllProducts = async () => {
    const response = await axios.get("http://localhost:8080/");
    if(response.status !== 200){
      throw new Error("Failed to get all the products");
      }    
    setProducts(JSON.stringify(response.data));  
  }

  const addProduct = async () => {
    const response = await axios.post("http://localhost:8080/",{productName,productPrice});
    if(response.status !== 200){
      throw new Error("Failed to add a product");
    }
    setProducts((prev) => prev + JSON.stringify(response.data));
  }

  const updateProduct = async () => {
    const response = await axios.put(`http://localhost:8080/${updateProductID}`,
      {productID:updateProductID, productName:updateProductName, productPrice:updateProductPrice});

    if(response.status !== 200){
      throw new Error("Failed to update the product");
    }
    showAllProducts();
  }

  const deleteProduct = async () => {
    const response = await axios.delete(`http://localhost:8080/${productID}`);
    if(response.status !== 200){
      throw new Error("Failed to remove the product");
    }
    showAllProducts();
  }

  useEffect(() => {
    showAllProducts();
  },[]);

  const changeProductName = (name) => {
    setProductName(name);
  }

  const changeProductPrice = (price) => {
    setProductPrice(price);
  }

  const changeProductID = (inputProductID) => {
    setProductID(inputProductID);
  }
  
  const changeUpdateProductID = (e) => {
    setUpdateProductID(e);
  }

  const changeUpdateProductName = (e) => {
    setUpdateProductName(e);
  }

  const changeUpdateProductPrice = (e) => {
    setUpdateProductPrice(e);
  }


  return (<>
    <div>
    {/*Adding A Product*/ }
    <label>
    <button onClick={addProduct}>Add Product</button>

    <input type="text" placeholder="Product Name..." 
    onChange={(e) => changeProductName(e.target.value)} value={productName} />

    <input type="number" placeholder="Product Price..." 
    onChange={(e) => changeProductPrice(e.target.value)} value={productPrice}/>
    </label>


    {/*Deleting A Product*/ }
    <br /><br /><br />
    <button onClick={deleteProduct}>Enter ID to remove a product!</button>
    <input type="number" placeholder="Product ID..." 
    onChange={(e) => changeProductID(e.target.value)} value={productID}/>


    {/*Updating A Product*/ }
    <br /><br /><br />
    <button onClick={updateProduct}>Enter Details to update a Product:</button>

    <input type="number" placeholder="Product ID..." 
    onChange={(e) => changeUpdateProductID(e.target.value)} value={updateProductID}/>

    <input type="text" placeholder="Product Name.." 
    onChange={(e) => changeUpdateProductName(e.target.value)} value={updateProductName}/>

    <input type="number" placeholder="Product Price..." 
    onChange={(e) => changeUpdateProductPrice(e.target.value)} value={updateProductPrice}/>



    <br/><br/><br/>
    <div style={{border: "2px solid green", 
      background: "black", color: "white", fontFamily: "verdana"}}>      
      <h5>{products}</h5>      
    </div>


    </div>
  </>
  )
}

export default App
