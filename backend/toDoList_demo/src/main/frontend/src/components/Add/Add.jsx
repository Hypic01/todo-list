import React, { useState } from 'react'
import styles from './Add.module.css';

const Add = ({ addItem }) => {

  const [add, setAdd] = useState('');

  const handleKeyDown  = (event) => {
    if(event.key === "Enter"){
      submitItem();
    }
  }

  const handleChange = (event) => {
    setAdd(event.target.value);
  };

  const submitItem = () => {
    if(add.length !== 0) {
      console.log('Submitted:', add);
      addItem(add);
      setAdd('');
    } else {
      alert("The input is blank!");
    }
  };

  return (
    <div className={styles.add}>
      <input 
        type="text" 
        className={styles.add_textbox} 
        value={add}
        onChange={handleChange} 
        onKeyDown={handleKeyDown} />
      <button onClick={submitItem} className={styles.add_button}>Add</button>
    </div>
  )
}

export default Add