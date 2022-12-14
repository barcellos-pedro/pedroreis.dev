import Image from 'next/image'

import { name } from '../layout/layout'
import utilStyles from '../../styles/utils.module.css'

export default function Header() {
  return (
    <>
      <Image
        priority
        src="/images/profile.jpg"
        className={utilStyles.borderCircle}
        height={144}
        width={144}
        alt={name}
      />
      <h1 className={utilStyles.heading2Xl}>{name}</h1>
    </>
  )
}
