import './App.css'
import { SelectChangeEvent } from '@mui/material'
import { useState } from 'react'
import MainToolBar from './components/toolbar/MainToolBar'


function App() {
  const periods = ['Week', 'Month', 'Year']
  const [selectedPeriod, setSelectedPeriod] = useState(periods[1]) // Default to 'Month'

  const wallets = ['all','wallet1','wallet2'] // Example wallet IDs
  // post implementation, this would fetch these from the API
  const [selectedWallet, setSelectedWallet] = useState(wallets[0])

  const [isDrawerOpen, setIsDrawerOpen] = useState(false)
  
  const toggleDrawer = () => {
    setIsDrawerOpen(!isDrawerOpen)
  }
  
  const handlePeriodChange =(event: SelectChangeEvent) => {
    setSelectedPeriod(event.target.value as string)
  }
  const handleWalletChange =(event: SelectChangeEvent) => {
    setSelectedWallet(event.target.value as string)
  }

  return (
    <div>
      <MainToolBar 
      isDrawerOpen={isDrawerOpen}
      toggleDrawer={ toggleDrawer }
      selectedPeriod={selectedPeriod}
      handlePeriodChange={ handlePeriodChange }
      selectedWallet={selectedWallet}
      handleWalletChange={ handleWalletChange }
      onRefresh={function (): void { throw new Error('Function not implemented.')} }    
      onClose={function (): void { throw new Error('Function not implemented.') } }>
      </MainToolBar>
    </div>
  )
}

export default App
