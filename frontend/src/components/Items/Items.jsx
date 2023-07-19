import React from 'react'
import styles from './Items.module.css';

import close from '../../images/close.png';
import pen from '../../images/pen.png';

const Items = ({ item, deleteItem }) => {

  return (
    <div className={styles.item}>
      <label>
        <div className={styles.container}>
          <input type="checkbox" className={styles.checkbox}/>
          <span className={`${styles.item_name} ${styles.crossed_out}`}>{item}</span>
        </div>
      </label>
      <img 
        src={pen}
        alt="pen"
        className={`${styles.pen} ${styles.visible}`}/>
      <img 
        src={close}
        alt="close"
        onClick={() => deleteItem(item)}
        className={`${styles.close} ${styles.visible}`}/>
    </div>
  )
}

export default Items